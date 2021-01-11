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

import io.renren.modules.manage.entity.ManageParamGroupEntity;
import io.renren.modules.manage.service.ManageParamGroupService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 参数组表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("manage/manageparamgroup")
public class ManageParamGroupController {
    @Autowired
    private ManageParamGroupService manageParamGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageparamgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageParamGroupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    @RequiresPermissions("manage:manageparamgroup:info")
    public R info(@PathVariable("groupId") Long groupId){
		ManageParamGroupEntity manageParamGroup = manageParamGroupService.getById(groupId);

        return R.ok().put("manageParamGroup", manageParamGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageparamgroup:save")
    public R save(@RequestBody ManageParamGroupEntity manageParamGroup){
		manageParamGroupService.save(manageParamGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageparamgroup:update")
    public R update(@RequestBody ManageParamGroupEntity manageParamGroup){
		manageParamGroupService.updateById(manageParamGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageparamgroup:delete")
    public R delete(@RequestBody Long[] groupIds){
		manageParamGroupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }

}
