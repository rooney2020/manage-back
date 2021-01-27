package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.ManageTaskEntity;
import io.renren.modules.manage.service.ManageTaskService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目任务表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("/manage-task")
public class ManageTaskController {
    @Autowired
    private ManageTaskService manageTaskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        Long projectId = null;
        if (params.get("projectId") != null && !"".equals(params.get("projectId"))) {
            projectId = Long.parseLong((String) params.get("projectId"));
        } else {
            return R.error("项目id不能为空");
        }
        PageUtils page = manageTaskService.queryPage(params, projectId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{taskId}")
    @RequiresPermissions("generator:managetask:info")
    public R info(@PathVariable("taskId") Long taskId){
		ManageTaskEntity manageTask = manageTaskService.getById(taskId);

        return R.ok().put("manageTask", manageTask);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:managetask:save")
    public R save(@RequestBody ManageTaskEntity manageTask){
		manageTaskService.save(manageTask);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:managetask:update")
    public R update(@RequestBody ManageTaskEntity manageTask){
		manageTaskService.updateById(manageTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:managetask:delete")
    public R delete(@RequestBody Long[] taskIds){
		manageTaskService.removeByIds(Arrays.asList(taskIds));

        return R.ok();
    }

}
