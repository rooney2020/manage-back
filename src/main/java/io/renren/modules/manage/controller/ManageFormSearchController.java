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

import io.renren.modules.manage.entity.ManageFormSearchEntity;
import io.renren.modules.manage.service.ManageFormSearchService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 自主填报-动态表单-记录搜索
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("manage/manageformsearch")
public class ManageFormSearchController {
    @Autowired
    private ManageFormSearchService manageFormSearchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageformsearch:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageFormSearchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{searchId}")
    @RequiresPermissions("manage:manageformsearch:info")
    public R info(@PathVariable("searchId") Long searchId){
		ManageFormSearchEntity manageFormSearch = manageFormSearchService.getById(searchId);

        return R.ok().put("manageFormSearch", manageFormSearch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageformsearch:save")
    public R save(@RequestBody ManageFormSearchEntity manageFormSearch){
		manageFormSearchService.save(manageFormSearch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageformsearch:update")
    public R update(@RequestBody ManageFormSearchEntity manageFormSearch){
		manageFormSearchService.updateById(manageFormSearch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageformsearch:delete")
    public R delete(@RequestBody Long[] searchIds){
		manageFormSearchService.removeByIds(Arrays.asList(searchIds));

        return R.ok();
    }

}
