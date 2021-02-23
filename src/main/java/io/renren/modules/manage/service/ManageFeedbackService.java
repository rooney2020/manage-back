package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageFeedbackEntity;

import java.util.Map;

/**
 * 反馈信息表
 */
public interface ManageFeedbackService extends IService<ManageFeedbackEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

