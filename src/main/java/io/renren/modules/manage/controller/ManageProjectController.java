package io.renren.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.manage.entity.ManageProjectEntity;
import io.renren.modules.manage.service.ManageProjectService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 项目信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("/manage-project")
public class ManageProjectController extends AbstractController {
    @Autowired
    private ManageProjectService manageProjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        Integer current = null;
        if (params.get("page") != null && !"".equals(params.get("page"))) {
            current = Integer.parseInt((String) params.get("page"));
        }
        Integer limit = null;
        if (params.get("limit") != null && !"".equals(params.get("limit"))) {
            limit = Integer.parseInt((String) params.get("limit"));
        }
        Page<ManageProjectEntity> ipage = new Page<>(current, limit);
        PageUtils page = new PageUtils(manageProjectService.selectUserPage(ipage, getUserId()));

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    @RequiresPermissions("generator:manageproject:info")
    public R info(@PathVariable("projectId") Long projectId){
		ManageProjectEntity manageProject = manageProjectService.getById(projectId);

        return R.ok().put("manageProject", manageProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:manageproject:save")
    public R save(@RequestBody ManageProjectEntity manageProject){
		manageProjectService.save(manageProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageProjectEntity manageProject){
		manageProjectService.updateById(manageProject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:manageproject:delete")
    public R delete(@RequestBody Long[] projectIds){
		manageProjectService.removeByIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
