package io.renren.modules.manage.controller;

import java.util.*;

import io.renren.common.utils.Constant;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.manage.service.ManageMessageService;
import io.renren.modules.manage.utils.CommonUtil;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.manage.entity.ManageLeaveEntity;
import io.renren.modules.manage.service.ManageLeaveService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 请假信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("/manage-leave")
public class ManageLeaveController extends AbstractController {
    @Autowired
    private ManageLeaveService manageLeaveService;
    @Autowired
    private ManageMessageService manageMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageleave:list")
    public R list(@RequestParam Map<String, Object> params) {
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("dealId", getUserId());
        }
        PageUtils page = manageLeaveService.getList(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{leaveId}")
    @RequiresPermissions("manage:manageleave:info")
    public R info(@PathVariable("leaveId") Long leaveId) {
        ManageLeaveEntity manageLeave = manageLeaveService.getById(leaveId);

        return R.ok().put("manageLeave", manageLeave);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("manage:manageleave:save")
    public R save(@RequestBody ManageLeaveEntity manageLeave) {
        manageLeave.setUserId(getUserId());
        manageLeave.setCreateTime(new Date());
        manageLeave.setStatus(0);
        ValidatorUtils.validateEntity(manageLeave, AddGroup.class);
        if (manageLeave.getTotalCount() % 4 != 0) {
            return R.error("总工时必须是4的倍数");
        }
        manageLeaveService.save(manageLeave);
        ManageMessageEntity msg = CommonUtil.msg(0L, getUser().getSuperId() == null ? 1 : getUser().getSuperId(), "您的员工\"" + getUser().getChineseName() + "\"提交了请假申请！");
        manageMessageService.save(msg);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageleave:update")
    public R update(@RequestBody ManageLeaveEntity manageLeave) {
        ValidatorUtils.validateEntity(manageLeave, UpdateGroup.class);
        manageLeaveService.updateById(manageLeave);

        return R.ok();
    }

    /**
     * 处理
     */
    @RequestMapping("/deal")
    @RequiresPermissions("manage:manageleave:deal")
    public R deal(@RequestBody ManageLeaveEntity manageLeave) {
        manageLeave.setDealId(getUserId());
        manageLeave.setEtlTime(new Date());
        ValidatorUtils.validateEntity(manageLeave, DealGroup.class);
        ManageLeaveEntity entity = manageLeaveService.getById(manageLeave.getLeaveId());
        if (entity == null) {
            return R.error("请假信息不存在");
        }
        if (entity.getStatus() != 0) {
            return R.error("该请假信息已被审核");
        }
        manageLeaveService.updateById(manageLeave);
        String message = "您的上级\"" + getUser().getChineseName() + "\"" +
                (entity.getStatus() == 1 ? "批准" : "拒绝") + "了您的请假申请" + entity.getLeaveId() + "！";
        ManageMessageEntity msg = CommonUtil.msg(0L, entity.getUserId(), message);
        manageMessageService.save(msg);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageleave:delete")
    public R delete(@RequestBody Long[] leaveIds) {
        manageLeaveService.removeByIds(Arrays.asList(leaveIds));

        return R.ok();
    }

    /**
     * 员工请假信息
     */
    @GetMapping("/personal")
    public R personal() {
        List<Map<String, Object>> personal = manageLeaveService.personal(getUserId());
        return R.ok().put("data", personal);
    }

    /**
     * 请假记录
     */
    @GetMapping("/history")
    public R history(@RequestParam Map<String, Object> params) {
        PageUtils page = manageLeaveService.history(params, getUserId());
        return R.ok().put("page", page);
    }

    @GetMapping("/records")
    public R records(@RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate) {
        List<SysUserEntity> list = manageLeaveService.records(beginDate, endDate, getUserId());
        return R.ok().put("data", list);
    }
}
