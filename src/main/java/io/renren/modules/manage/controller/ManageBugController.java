package io.renren.modules.manage.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.manage.entity.ManageBugEntity;
import io.renren.modules.manage.service.ManageBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 项目BUG表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@RestController
@RequestMapping("/manage-bug")
public class ManageBugController {
    @Autowired
    private ManageBugService manageBugService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        Long projectId = null;
        if (params.get("projectId") != null && !"".equals(params.get("projectId"))) {
            projectId = Long.parseLong((String) params.get("projectId"));
        } else {
            return R.error("项目id不能为空");
        }
        PageUtils page = manageBugService.queryPage(params, projectId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bugId}")
    public R info(@PathVariable("bugId") Long bugId){
		ManageBugEntity manageBug = manageBugService.getById(bugId);

        return R.ok().put("manageBug", manageBug);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ManageBugEntity manageBug){
		manageBugService.save(manageBug);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ManageBugEntity manageBug){
		manageBugService.updateById(manageBug);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] bugIds){
		manageBugService.removeByIds(Arrays.asList(bugIds));

        return R.ok();
    }

}
