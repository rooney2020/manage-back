package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageMessageEntity;

import java.util.Map;

/**
 * 消息表
 */
public interface ManageMessageService extends IService<ManageMessageEntity> {

    PageUtils queryPage(Map<String, Object> params, Long userId, Integer isRead);

    IPage<ManageMessageEntity> selectUserPage(Page<ManageMessageEntity> page, Long userId, Integer isRead);
}

