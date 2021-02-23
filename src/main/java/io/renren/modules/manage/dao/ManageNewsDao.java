package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.manage.entity.ManageNewsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 新闻
 */
@Mapper
public interface ManageNewsDao extends BaseMapper<ManageNewsEntity> {
}
