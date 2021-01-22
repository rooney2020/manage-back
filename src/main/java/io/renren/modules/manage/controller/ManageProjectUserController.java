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

import io.renren.modules.manage.entity.ManageProjectUserEntity;
import io.renren.modules.manage.service.ManageProjectUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目成员表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("generator/manageprojectuser")
public class ManageProjectUserController {
    @Autowired
    private ManageProjectUserService manageProjectUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:manageprojectuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageProjectUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    @RequiresPermissions("generator:manageprojectuser:info")
    public R info(@PathVariable("projectId") Long projectId){
		ManageProjectUserEntity manageProjectUser = manageProjectUserService.getById(projectId);

        return R.ok().put("manageProjectUser", manageProjectUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:manageprojectuser:save")
    public R save(@RequestBody ManageProjectUserEntity manageProjectUser){
		manageProjectUserService.save(manageProjectUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:manageprojectuser:update")
    public R update(@RequestBody ManageProjectUserEntity manageProjectUser){
		manageProjectUserService.updateById(manageProjectUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:manageprojectuser:delete")
    public R delete(@RequestBody Long[] projectIds){
		manageProjectUserService.removeByIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
