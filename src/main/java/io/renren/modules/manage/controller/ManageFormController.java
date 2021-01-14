package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.modules.manage.dao.ManageParamDao;
import io.renren.modules.manage.dao.ManageParamGroupDao;
import io.renren.modules.manage.entity.CodeEntity;
import io.renren.modules.manage.entity.ManageParamEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class ManageFormController extends AbstractController {
    @Autowired
    private ManageFormService manageFormService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = manageFormService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{formId}")
    @RequiresPermissions("manage:manageform:info")
    public R info(@PathVariable("formId") Long formId) {
        ManageFormEntity manageForm = manageFormService.getById(formId);

        return R.ok().put("manageForm", manageForm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageform:save")
    public R save(@RequestBody ManageFormEntity manageForm) {
        manageForm.setEtlTime(new Date());
        manageForm.setUserId(getUserId());
        ValidatorUtils.validateEntity(manageForm, AddGroup.class);
        if (manageForm.getIsVisit() == 1) {
            ValidatorUtils.validateEntity(manageForm, DealGroup.class);
        }
        manageFormService.save(manageForm);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageform:update")
    public R update(@RequestBody ManageFormEntity manageForm) {
        manageFormService.updateById(manageForm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageform:delete")
    public R delete(@RequestBody Long[] formIds) {
        manageFormService.removeByIds(Arrays.asList(formIds));

        return R.ok();
    }
}
