package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManageParamGroupEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 参数组
 */
@Mapper
public interface ManageParamGroupDao extends BaseMapper<ManageParamGroupEntity> {

    Long getIdByName(String groupName);

    Long getParamIdByName(String paramName);
}
