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

import io.renren.modules.manage.entity.ManageBugEntity;
import io.renren.modules.manage.service.ManageBugService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目BUG表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("generator/managebug")
public class ManageBugController {
    @Autowired
    private ManageBugService manageBugService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:managebug:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageBugService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bugId}")
    @RequiresPermissions("generator:managebug:info")
    public R info(@PathVariable("bugId") Long bugId){
		ManageBugEntity manageBug = manageBugService.getById(bugId);

        return R.ok().put("manageBug", manageBug);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:managebug:save")
    public R save(@RequestBody ManageBugEntity manageBug){
		manageBugService.save(manageBug);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:managebug:update")
    public R update(@RequestBody ManageBugEntity manageBug){
		manageBugService.updateById(manageBug);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:managebug:delete")
    public R delete(@RequestBody Long[] bugIds){
		manageBugService.removeByIds(Arrays.asList(bugIds));

        return R.ok();
    }

}
