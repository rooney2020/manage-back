package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageFormSearchEntity;

import java.util.Map;

/**
 * 自主填报-动态表单-记录搜索
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
public interface ManageFormSearchService extends IService<ManageFormSearchEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

