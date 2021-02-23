package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageNewsEntity;

import java.util.Map;

/**
 * 新闻表
 */
public interface ManageNewsService extends IService<ManageNewsEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
