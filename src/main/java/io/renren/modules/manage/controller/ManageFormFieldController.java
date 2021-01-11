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

import io.renren.modules.manage.entity.ManageFormFieldEntity;
import io.renren.modules.manage.service.ManageFormFieldService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 自主填报-动态表单-字段
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("manage/manageformfield")
public class ManageFormFieldController {
    @Autowired
    private ManageFormFieldService manageFormFieldService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageformfield:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageFormFieldService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fieldId}")
    @RequiresPermissions("manage:manageformfield:info")
    public R info(@PathVariable("fieldId") Long fieldId){
		ManageFormFieldEntity manageFormField = manageFormFieldService.getById(fieldId);

        return R.ok().put("manageFormField", manageFormField);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageformfield:save")
    public R save(@RequestBody ManageFormFieldEntity manageFormField){
		manageFormFieldService.save(manageFormField);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageformfield:update")
    public R update(@RequestBody ManageFormFieldEntity manageFormField){
		manageFormFieldService.updateById(manageFormField);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageformfield:delete")
    public R delete(@RequestBody Long[] fieldIds){
		manageFormFieldService.removeByIds(Arrays.asList(fieldIds));

        return R.ok();
    }

}
