package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManageParamEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.manage.entity.ManageParamGroupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 参数
 */
@Mapper
public interface ManageParamDao extends BaseMapper<ManageParamEntity> {
    @SuppressWarnings("all")
    List<ManageParamGroupEntity> getList(Map<String, Object> params);

    List<ManageParamEntity> getParamList(@Param("groupName") String groupName);

    int removeByGroupIds(@Param("groupIds") Long[] groupIds);

    int getListSize(Map<String, Object> params);

    List<ManageParamEntity> getParams(@Param("groupName") String groupName, @Param("code") String code);
}
