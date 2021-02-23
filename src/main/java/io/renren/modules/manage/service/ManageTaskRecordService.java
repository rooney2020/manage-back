package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;

import java.util.Map;

/**
 * 项目任务记录表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
public interface ManageTaskRecordService extends IService<ManageTaskRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

