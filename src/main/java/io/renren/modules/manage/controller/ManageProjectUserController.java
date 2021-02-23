package io.renren.modules.manage.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.manage.entity.ManageProjectUserEntity;
import io.renren.modules.manage.service.ManageProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 项目成员表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("/manage-projectuser")
public class ManageProjectUserController {
    @Autowired
    private ManageProjectUserService manageProjectUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageProjectUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    public R info(@PathVariable("projectId") Long projectId){
		ManageProjectUserEntity manageProjectUser = manageProjectUserService.getById(projectId);

        return R.ok().put("manageProjectUser", manageProjectUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageProjectUserEntity manageProjectUser){
		manageProjectUserService.save(manageProjectUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageProjectUserEntity manageProjectUser){
		manageProjectUserService.updateById(manageProjectUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] projectIds){
		manageProjectUserService.removeByIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
