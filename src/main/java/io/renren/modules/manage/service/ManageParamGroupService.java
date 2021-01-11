package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageParamGroupEntity;

import java.util.Map;

/**
 * 参数组表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
public interface ManageParamGroupService extends IService<ManageParamGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

