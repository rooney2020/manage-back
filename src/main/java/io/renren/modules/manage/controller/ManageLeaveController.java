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

import io.renren.modules.manage.entity.ManageLeaveEntity;
import io.renren.modules.manage.service.ManageLeaveService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 请假信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("manage/manageleave")
public class ManageLeaveController {
    @Autowired
    private ManageLeaveService manageLeaveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageleave:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageLeaveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{leaveId}")
    @RequiresPermissions("manage:manageleave:info")
    public R info(@PathVariable("leaveId") Long leaveId){
		ManageLeaveEntity manageLeave = manageLeaveService.getById(leaveId);

        return R.ok().put("manageLeave", manageLeave);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageleave:save")
    public R save(@RequestBody ManageLeaveEntity manageLeave){
		manageLeaveService.save(manageLeave);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageleave:update")
    public R update(@RequestBody ManageLeaveEntity manageLeave){
		manageLeaveService.updateById(manageLeave);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageleave:delete")
    public R delete(@RequestBody Long[] leaveIds){
		manageLeaveService.removeByIds(Arrays.asList(leaveIds));

        return R.ok();
    }

}
