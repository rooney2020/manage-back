package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageProjectEntity;
import io.renren.modules.manage.entity.ManageTaskEntity;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目任务表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
public interface ManageTaskService extends IService<ManageTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ManageTaskEntity> getRequirements();

    IPage<ManageTaskEntity> getList(Page<ManageTaskEntity> ipage, Long userId, Map<String, Object> params);

    List<ManageTaskRecordEntity> worktime(Long taskId);
}

