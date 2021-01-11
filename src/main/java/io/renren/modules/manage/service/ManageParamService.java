package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageParamEntity;

import java.util.Map;

/**
 * 参数表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
public interface ManageParamService extends IService<ManageParamEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

