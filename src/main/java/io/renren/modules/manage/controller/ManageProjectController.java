package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.entity.ManageProjectEntity;
import io.renren.modules.manage.service.ManageProjectService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 项目信息
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
    public R list(@RequestParam Map<String, Object> params) {
        Integer current = null;
        if (params.get("page") != null && !"".equals(params.get("page"))) {
            current = Integer.parseInt((String) params.get("page"));
        }
        Integer limit = null;
        if (params.get("limit") != null && !"".equals(params.get("limit"))) {
            limit = Integer.parseInt((String) params.get("limit"));
        }
        Page<ManageProjectEntity> ipage = new Page<>(current, limit);
        PageUtils page = new PageUtils(manageProjectService.selectUserPage(ipage, getUserId(), params));

        return R.ok().put("page", page);
    }

    @RequestMapping("/projects")
    public R allProjects() {
        return R.ok().put("data", manageProjectService.getAllProjects());
    }

    @RequestMapping("/projects/num")
    public R projectsNum() {
        return R.ok().put("data", manageProjectService.getAllProjects().size());
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    public R info(@PathVariable("projectId") Long projectId) {
        ManageProjectEntity manageProject = manageProjectService.getById(projectId);

        return R.ok().put("manageProject", manageProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageProjectEntity manageProject) {
        manageProject.setCreateUserId(getUserId());
        manageProject.setCreateTime(new Date());
        manageProject.setUpdateTime(new Date());
        ValidatorUtils.validateEntity(manageProject, AddGroup.class);
        manageProjectService.save(manageProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageProjectEntity manageProject) {
        manageProject.setUpdateTime(new Date());
        ValidatorUtils.validateEntity(manageProject, UpdateGroup.class);
        manageProjectService.updateById(manageProject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] projectIds) {
        manageProjectService.removeByIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
