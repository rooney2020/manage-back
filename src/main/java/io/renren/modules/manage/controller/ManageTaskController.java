package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.entity.ManageTaskEntity;
import io.renren.modules.manage.service.ManageTaskService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 项目任务表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("/manage-task")
public class ManageTaskController extends AbstractController {
    @Autowired
    private ManageTaskService manageTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
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
    public R info(@PathVariable("taskId") Long taskId){
		ManageTaskEntity manageTask = manageTaskService.getById(taskId);

        return R.ok().put("manageTask", manageTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageTaskEntity manageTask){
        manageTask.setCreateTime(new Date());
        manageTask.setCreateUserId(getUserId());
        ValidatorUtils.validateEntity(manageTask, AddGroup.class);
		manageTaskService.save(manageTask);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageTaskEntity manageTask){
        ValidatorUtils.validateEntity(manageTask, UpdateGroup.class);
		manageTaskService.updateById(manageTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] taskIds){
		manageTaskService.removeByIds(Arrays.asList(taskIds));

        return R.ok();
    }

}
