package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageParamGroupEntity;

import java.util.Map;

/**
 * 参数组表
 */
public interface ManageParamGroupService extends IService<ManageParamGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

