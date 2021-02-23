package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目任务记录
 */
@Mapper
public interface ManageTaskRecordDao extends BaseMapper<ManageTaskRecordEntity> {
}
