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

import io.renren.modules.manage.entity.ManageFormEntity;
import io.renren.modules.manage.service.ManageFormService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 自主填报-动态表单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:55
 */
@RestController
@RequestMapping("manage/manageform")
public class ManageFormController {
    @Autowired
    private ManageFormService manageFormService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageFormService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{formId}")
    @RequiresPermissions("manage:manageform:info")
    public R info(@PathVariable("formId") Long formId){
		ManageFormEntity manageForm = manageFormService.getById(formId);

        return R.ok().put("manageForm", manageForm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageform:save")
    public R save(@RequestBody ManageFormEntity manageForm){
		manageFormService.save(manageForm);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageform:update")
    public R update(@RequestBody ManageFormEntity manageForm){
		manageFormService.updateById(manageForm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageform:delete")
    public R delete(@RequestBody Long[] formIds){
		manageFormService.removeByIds(Arrays.asList(formIds));

        return R.ok();
    }

}
