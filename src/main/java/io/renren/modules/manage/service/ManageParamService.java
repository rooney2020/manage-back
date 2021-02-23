package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageParamEntity;

import java.util.Map;

/**
 * 参数表
 */
public interface ManageParamService extends IService<ManageParamEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getList(Map<String, Object> params);

    int removeByGroupIds(Long[] groupIds);
}

