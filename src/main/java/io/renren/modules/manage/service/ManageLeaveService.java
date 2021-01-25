package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageLeaveEntity;

import java.util.List;
import java.util.Map;

/**
 * 请假信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
public interface ManageLeaveService extends IService<ManageLeaveEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils getList(Map<String, Object> params);

    List<Map<String, Object>> personal(Long userId);

    PageUtils history(Map<String, Object> params, Long userId);
}

