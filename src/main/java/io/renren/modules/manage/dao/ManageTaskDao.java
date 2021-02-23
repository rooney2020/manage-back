package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageTaskEntity;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目任务
 */
@Mapper
public interface ManageTaskDao extends BaseMapper<ManageTaskEntity> {

    List<ManageTaskEntity> getRequirements();

    IPage<ManageTaskEntity> getList(Page<ManageTaskEntity> ipage, @Param("userId") Long userId, @Param("params") Map<String, Object> params);

    List<ManageTaskRecordEntity> worktime(Long taskId);
}
