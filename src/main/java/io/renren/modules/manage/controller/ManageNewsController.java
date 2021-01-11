package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.modules.manage.entity.ManageNewsEntity;
import io.renren.modules.manage.service.ManageNewsService;
import io.renren.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public R list(@RequestParam(value = "title", required = false) String title) {
        List<ManageNewsEntity> list = service.list(
                new QueryWrapper<ManageNewsEntity>().lambda()
                        .like(title != null && !"".equals(title), ManageNewsEntity::getTitle, title)
                        .orderBy(true, false, ManageNewsEntity::getCreateTime)
        );
        return R.ok().put("data", list).put("total", list.size());
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
        if (null == entity.getNewsId()) {
            return R.error("newsId不能为空");
        }
        boolean b = service.updateById(entity);
        if (!b) {
            return R.error("修改失败");
        }
        return R.ok();
    }
}
