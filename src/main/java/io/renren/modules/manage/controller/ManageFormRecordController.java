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

import io.renren.modules.manage.entity.ManageFormRecordEntity;
import io.renren.modules.manage.service.ManageFormRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 自主填报-动态表单-记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@RestController
@RequestMapping("manage/manageformrecord")
public class ManageFormRecordController {
    @Autowired
    private ManageFormRecordService manageFormRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manage:manageformrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = manageFormRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordId}")
    @RequiresPermissions("manage:manageformrecord:info")
    public R info(@PathVariable("recordId") Long recordId){
		ManageFormRecordEntity manageFormRecord = manageFormRecordService.getById(recordId);

        return R.ok().put("manageFormRecord", manageFormRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manage:manageformrecord:save")
    public R save(@RequestBody ManageFormRecordEntity manageFormRecord){
		manageFormRecordService.save(manageFormRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manage:manageformrecord:update")
    public R update(@RequestBody ManageFormRecordEntity manageFormRecord){
		manageFormRecordService.updateById(manageFormRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manage:manageformrecord:delete")
    public R delete(@RequestBody Long[] recordIds){
		manageFormRecordService.removeByIds(Arrays.asList(recordIds));

        return R.ok();
    }

}
