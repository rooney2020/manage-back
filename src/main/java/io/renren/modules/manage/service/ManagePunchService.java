package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManagePunchEntity;

import java.util.Map;

/**
 * 打卡签到表
 */
public interface ManagePunchService extends IService<ManagePunchEntity> {

    PageUtils queryPage(Map<String, Object> params);

    ManagePunchEntity getStatus(Long userId, Integer type);

    IPage<Map> selectUserPage(Page<Map> ipage, Long userId, String date);
}

