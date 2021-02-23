package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目任务记录表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Mapper
public interface ManageTaskRecordDao extends BaseMapper<ManageTaskRecordEntity> {
}
