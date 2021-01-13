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

import io.renren.modules.manage.entity.ManageParamEntity;
import io.renren.modules.manage.service.ManageParamService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 参数表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("/manage-param")
public class ManageParamController {
    @Autowired
    private ManageParamService manageParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageparam:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageParamService.getList(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{paramId}")
    @RequiresPermissions("manage:manageparam:info")
    public R info(@PathVariable("paramId") Long paramId){
		ManageParamEntity manageParam = manageParamService.getById(paramId);

        return R.ok().put("manageParam", manageParam);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageparam:save")
    public R save(@RequestBody ManageParamEntity manageParam){
		manageParamService.save(manageParam);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageparam:update")
    public R update(@RequestBody ManageParamEntity manageParam){
		manageParamService.updateById(manageParam);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageparam:delete")
    public R delete(@RequestBody Long[] paramIds){
		manageParamService.removeByIds(Arrays.asList(paramIds));

        return R.ok();
    }

}
