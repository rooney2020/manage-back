package io.renren.modules.manage.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.manage.service.ManageMessageService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 消息
 */
@RestController
@RequestMapping("/manage-message")
public class ManageMessageController extends AbstractController {
    @Autowired
    private ManageMessageService manageMessageService;

    /**
     * 消息已读
     */
    @RequestMapping("/read")
    public R read(@RequestParam Long[] msIds) {
        List<ManageMessageEntity> list = new ArrayList<>();
        for (Long msgId : msIds) {
            list.add(getMsg(msgId, 1));
        }
        manageMessageService.updateBatchById(list);

        return R.ok();
    }

    /**
     * 消息删除
     */
    @RequestMapping("/remove")
    public R remove(@RequestParam Long[] msIds) {
        manageMessageService.removeByIds(Arrays.asList(msIds));

        return R.ok();
    }

    public ManageMessageEntity getMsg(Long id, int status) {
        ManageMessageEntity entity = new ManageMessageEntity();
        entity.setIsRead(status);
        entity.setMsId(id);
        return entity;
    }

    /**
     * 列表 员工个人消息
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        Integer isRead = null;
        if (params.get("isRead") != null && !"".equals(params.get("isRead"))) {
            isRead = Integer.parseInt((String) params.get("isRead"));
        }
        Integer current = null;
        if (params.get("page") != null && !"".equals(params.get("page"))) {
            current = Integer.parseInt((String) params.get("page"));
        }
        Integer limit = null;
        if (params.get("limit") != null && !"".equals(params.get("limit"))) {
            limit = Integer.parseInt((String) params.get("limit"));
        }

        Page<ManageMessageEntity> ipage = new Page<>(current, limit);
        PageUtils page = new PageUtils(manageMessageService.selectUserPage(ipage, getUserId(), isRead));

        return R.ok().put("page", page);
    }

    @GetMapping("/count")
    public R count() {
        int count = manageMessageService.count(new QueryWrapper<ManageMessageEntity>().lambda()
                .eq(ManageMessageEntity::getMsTo, getUserId()).eq(ManageMessageEntity::getIsRead, 0));
        return R.ok().put("count", count);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{msId}")
    @RequiresPermissions("generator:managemessage:info")
    public R info(@PathVariable("msId") Long msId) {
        ManageMessageEntity manageMessage = manageMessageService.getById(msId);

        return R.ok().put("manageMessage", manageMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:managemessage:save")
    public R save(@RequestBody ManageMessageEntity manageMessage) {
        manageMessageService.save(manageMessage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:managemessage:update")
    public R update(@RequestBody ManageMessageEntity manageMessage) {
        manageMessageService.updateById(manageMessage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:managemessage:delete")
    public R delete(@RequestBody Long[] msIds) {
        manageMessageService.removeByIds(Arrays.asList(msIds));

        return R.ok();
    }

}
