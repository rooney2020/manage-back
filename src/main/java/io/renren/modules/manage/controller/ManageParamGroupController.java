package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.service.ManageParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.ManageParamGroupEntity;
import io.renren.modules.manage.service.ManageParamGroupService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 参数组
 */
@RestController
@RequestMapping("/manage-paramgroup")
public class ManageParamGroupController {
    @Autowired
    private ManageParamGroupService manageParamGroupService;
    @Autowired
    private ManageParamService manageParamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = manageParamGroupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    public R info(@PathVariable("groupId") Long groupId) {
        ManageParamGroupEntity manageParamGroup = manageParamGroupService.getById(groupId);

        return R.ok().put("manageParamGroup", manageParamGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageParamGroupEntity manageParamGroup) {
        ValidatorUtils.validateEntity(manageParamGroup, AddGroup.class);
        manageParamGroupService.save(manageParamGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageParamGroupEntity manageParamGroup) {
        ValidatorUtils.validateEntity(manageParamGroup, UpdateGroup.class);
        manageParamGroupService.updateById(manageParamGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public R delete(@RequestBody Long[] groupIds) {
        manageParamService.removeByGroupIds(groupIds);
        manageParamGroupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }

}
