package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageProjectUserEntity;

import java.util.Map;

/**
 * 项目成员表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
public interface ManageProjectUserService extends IService<ManageProjectUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

