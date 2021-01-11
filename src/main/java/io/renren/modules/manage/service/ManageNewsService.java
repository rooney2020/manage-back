package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageNewsEntity;

import java.util.Map;

/**
 * 请修改注释
 *
 * @author zhaoliyuan
 * @date 2021.01.06
 */
public interface ManageNewsService extends IService<ManageNewsEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
