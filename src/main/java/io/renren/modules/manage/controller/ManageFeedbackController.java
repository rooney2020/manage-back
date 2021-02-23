package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.manage.service.ManageMessageService;
import io.renren.modules.manage.utils.CommonUtil;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.ManageFeedbackEntity;
import io.renren.modules.manage.service.ManageFeedbackService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

/**
 * 反馈
 */
@RestController
@RequestMapping("/manage-feedback")
public class ManageFeedbackController extends AbstractController {
    @Autowired
    private ManageFeedbackService manageFeedbackService;
    @Autowired
    private ManageMessageService manageMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:managefeedback:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = manageFeedbackService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{feedId}")
    @RequiresPermissions("manage:managefeedback:info")
    public R info(@PathVariable("feedId") Long feedId) {
        ManageFeedbackEntity manageFeedback = manageFeedbackService.getById(feedId);

        return R.ok().put("manageFeedback", manageFeedback);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:managefeedback:save")
    public R save(@RequestBody ManageFeedbackEntity manageFeedback) {
        manageFeedback.setUserId(getUserId());
        manageFeedback.setStatus(0);
        manageFeedback.setCreateTime(new Date());
        manageFeedback.setMobile(getUser().getMobile());
        ValidatorUtils.validateEntity(manageFeedback, AddGroup.class);
        manageFeedbackService.save(manageFeedback);
        ManageMessageEntity msg = CommonUtil.msg(0L, 1L, "您的员工\"" + getUser().getChineseName() + "\"提交了反馈信息！");
        manageMessageService.save(msg);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:managefeedback:update")
    public R update(@RequestBody ManageFeedbackEntity manageFeedback) {
        manageFeedback.setResolveUserId(getUserId());
        manageFeedback.setEtlTime(new Date());
        manageFeedback.setStatus(1);
        ValidatorUtils.validateEntity(manageFeedback, UpdateGroup.class);
        manageFeedbackService.updateById(manageFeedback);
        ManageMessageEntity msg = CommonUtil.msg(0L, manageFeedback.getUserId(), "管理员处理了您的反馈信息！");
        manageMessageService.save(msg);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:managefeedback:delete")
    public R delete(@RequestBody Long[] feedIds) {
        manageFeedbackService.removeByIds(Arrays.asList(feedIds));

        return R.ok();
    }

}
