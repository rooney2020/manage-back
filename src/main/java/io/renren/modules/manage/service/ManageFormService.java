package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageFormEntity;
import io.renren.modules.manage.entity.ManageMessageEntity;

import java.util.Map;

/**
 * 自主填报-动态表单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:55
 */
public interface ManageFormService extends IService<ManageFormEntity> {

    PageUtils queryPage(Map<String, Object> params);

    IPage<ManageFormEntity> selectUserPage(Page<ManageFormEntity> ipage, Map<String, Object> params);
}

