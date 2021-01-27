package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.manage.entity.ManageProjectEntity;

import java.util.Map;

/**
 * 项目信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
public interface ManageProjectService extends IService<ManageProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    IPage<ManageProjectEntity> selectUserPage(Page<ManageProjectEntity> ipage, Long userId);
}

