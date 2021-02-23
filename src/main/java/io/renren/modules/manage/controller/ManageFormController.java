package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.modules.manage.entity.ManageFormEntity;
import io.renren.modules.manage.service.ManageFormService;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * 自主填报
 */
@RestController
@RequestMapping("/manage-form")
public class ManageFormController extends AbstractController {
    @Autowired
    private ManageFormService manageFormService;

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
        params.put("userId", getUserId());
        Page<ManageFormEntity> ipage = new Page<>(current, limit);
        PageUtils page = new PageUtils(manageFormService.selectUserPage(ipage, params));
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{formId}")
    public R info(@PathVariable("formId") Long formId) {
        ManageFormEntity manageForm = manageFormService.getById(formId);

        return R.ok().put("manageForm", manageForm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageFormEntity manageForm) {
        manageForm.setEtlTime(new Date());
        manageForm.setUserId(getUserId());
        ValidatorUtils.validateEntity(manageForm, AddGroup.class);
        if (manageForm.getIsVisit() == 1) {
            ValidatorUtils.validateEntity(manageForm, DealGroup.class);
        }
        if (!isReport()) {
            return R.error("今日已填报");
        }
        manageFormService.save(manageForm);
        return R.ok();
    }

    /**
     * 今日是否已经填报过
     */
    public boolean isReport() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        ManageFormEntity formEntity = manageFormService.getOne(new QueryWrapper<ManageFormEntity>().lambda()
                .eq(ManageFormEntity::getEtlTime, format)
                .eq(ManageFormEntity::getUserId, getUserId())
                .last("limit 1"));
        if (formEntity != null) {
            return false;
        }
        return true;
    }

    @GetMapping("/isreport")
    public R isReported() {
        return R.ok().put("isReported", !isReport());
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageFormEntity manageForm) {
        manageFormService.updateById(manageForm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] formIds) {
        manageFormService.removeByIds(Arrays.asList(formIds));

        return R.ok();
    }
}
