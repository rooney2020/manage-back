package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.manage.entity.ManageTaskEntity;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;
import io.renren.modules.manage.service.ManageMessageService;
import io.renren.modules.manage.service.ManageTaskRecordService;
import io.renren.modules.manage.service.ManageTaskService;
import io.renren.modules.manage.utils.CommonUtil;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 项目任务
 */
@RestController
@RequestMapping("/manage-task")
public class ManageTaskController extends AbstractController {
    @Autowired
    private ManageTaskService manageTaskService;
    @Autowired
    private ManageTaskRecordService manageTaskRecordService;
    @Autowired
    private ManageMessageService manageMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        Integer current = null;
        if (params.get("page") != null && !"".equals(params.get("page"))) {
            current = Integer.parseInt((String) params.get("page"));
        }
        Integer limit = null;
        if (params.get("limit") != null && !"".equals(params.get("limit"))) {
            limit = Integer.parseInt((String) params.get("limit"));
        }
        Page<ManageTaskEntity> ipage = new Page<>(current, limit);
        PageUtils page = new PageUtils(manageTaskService.getList(ipage, getUserId(), params));

        return R.ok().put("page", page);
    }

    @RequestMapping("/assign/num")
    public R assignNum() {
        List<ManageTaskEntity> list = manageTaskService.list(new QueryWrapper<ManageTaskEntity>().lambda()
                .eq(ManageTaskEntity::getAssigneeId, getUserId()));
        return R.ok().put("data", list.size());
    }

    /**
     * 所有需求任务
     */
    @GetMapping("/requirements")
    public R requirements() {
        return R.ok().put("data", manageTaskService.getRequirements());
    }

    @GetMapping("/status")
    public R status(@RequestParam("taskId") Long taskId, @RequestParam("status") int status) {
        ManageTaskEntity task = new ManageTaskEntity();
        task.setTaskId(taskId);
        task.setStatus(status);
        ValidatorUtils.validateEntity(task, DealGroup.class);
        return R.ok();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{taskId}")
    public R info(@PathVariable("taskId") Long taskId) {
        ManageTaskEntity manageTask = manageTaskService.getById(taskId);

        return R.ok().put("manageTask", manageTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageTaskEntity manageTask) {
        manageTask.setCreateTime(new Date());
        manageTask.setCreateUserId(getUserId());
        manageTask.setStatus(0);
        ValidatorUtils.validateEntity(manageTask, AddGroup.class);
        manageTaskService.save(manageTask);
        ManageMessageEntity msg = CommonUtil.msg(0L, manageTask.getAssigneeId(), "\"" + getUser().getChineseName() + "\"给您指派了新任务！");
        manageMessageService.save(msg);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageTaskEntity manageTask) {
        ValidatorUtils.validateEntity(manageTask, UpdateGroup.class);
        manageTaskService.updateById(manageTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] taskIds) {
        manageTaskService.removeByIds(Arrays.asList(taskIds));

        return R.ok();
    }

    @GetMapping("/worktime")
    public R worktime(@RequestParam("taskId") Long taskId) {
        return R.ok().put("data", manageTaskService.worktime(taskId));
    }

    @PostMapping("/worktime/save")
    @Transactional(rollbackFor = Exception.class)
    public R addWorkTime(@RequestBody List<ManageTaskRecordEntity> records) {
        for (ManageTaskRecordEntity record : records) {
            if (record.getRecordId() != null) {
                ValidatorUtils.validateEntity(record, UpdateGroup.class);
            } else {
                record.setCreateUserId(getUserId());
                record.setCreateTime(new Date());
                ValidatorUtils.validateEntity(record, AddGroup.class);
            }
        }
        manageTaskRecordService.saveOrUpdateBatch(records);
        return R.ok();
    }

    @GetMapping("/worktime/delete")
    public R deleteWorkTime(@RequestParam("recordId") Long recordId) {
        manageTaskRecordService.removeById(recordId);
        return R.ok();
    }
}
