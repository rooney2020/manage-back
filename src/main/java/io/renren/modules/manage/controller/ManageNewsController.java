package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.manage.entity.ManageNewsEntity;
import io.renren.modules.manage.service.ManageNewsService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manage-news")
public class ManageNewsController extends AbstractController {
    @Autowired
    private ManageNewsService service;

    /**
     * 新闻列表
     */
    @GetMapping("/list/active")
    public R activeList() {
        List<ManageNewsEntity> list = service.list(
                new QueryWrapper<ManageNewsEntity>().lambda()
                        .eq(ManageNewsEntity::getIsActive, 0)
                        .orderBy(true, false, ManageNewsEntity::getCreateTime)
        );
        return R.ok().put("data", list).put("total", list.size());
    }

    /**
     * 新闻管理列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = service.queryPage(params);
        return R.ok().put("data", page);
    }

    /**
     * 添加新闻
     */
    @PostMapping("/create")
    public R create(@RequestBody ManageNewsEntity entity) {
        entity.setIsActive(0);
        entity.setCreateTime(new Date());
        entity.setCreateUserId(getUserId());
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        service.save(entity);
        return R.ok();
    }

    /**
     * 修改新闻
     */
    @PostMapping("/update")
    public R updateNews(@RequestBody ManageNewsEntity entity) {
        ValidatorUtils.validateEntity(entity, UpdateGroup.class);
        boolean b = service.updateById(entity);
        if (!b) {
            return R.error("修改失败");
        }
        return R.ok();
    }
}
