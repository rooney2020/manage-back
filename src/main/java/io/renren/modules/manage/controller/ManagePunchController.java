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

import io.renren.modules.manage.entity.ManagePunchEntity;
import io.renren.modules.manage.service.ManagePunchService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 打卡签到表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("manage/managepunch")
public class ManagePunchController {
    @Autowired
    private ManagePunchService managePunchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:managepunch:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = managePunchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{punchId}")
    @RequiresPermissions("manage:managepunch:info")
    public R info(@PathVariable("punchId") Long punchId){
		ManagePunchEntity managePunch = managePunchService.getById(punchId);

        return R.ok().put("managePunch", managePunch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:managepunch:save")
    public R save(@RequestBody ManagePunchEntity managePunch){
		managePunchService.save(managePunch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:managepunch:update")
    public R update(@RequestBody ManagePunchEntity managePunch){
		managePunchService.updateById(managePunch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:managepunch:delete")
    public R delete(@RequestBody Long[] punchIds){
		managePunchService.removeByIds(Arrays.asList(punchIds));

        return R.ok();
    }

}
