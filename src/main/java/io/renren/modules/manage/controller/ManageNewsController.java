package io.renren.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.R;
import io.renren.modules.manage.entity.ManageNewsEntity;
import io.renren.modules.manage.service.ManageNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manage-news")
public class ManageNewsController {
    @Autowired
    private ManageNewsService service;

    @GetMapping("/list")
    public R list() {
        List<ManageNewsEntity> list = service.list(
                new QueryWrapper<ManageNewsEntity>().lambda()
                        .eq(ManageNewsEntity::getIsActive, 0)
                        .orderBy(true, false, ManageNewsEntity::getCreateTime)
        );
        return R.ok().put("data", list).put("total", list.size());
    }
}
