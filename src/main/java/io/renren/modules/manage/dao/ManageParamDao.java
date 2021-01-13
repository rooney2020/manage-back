package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManageParamEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 参数表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Mapper
public interface ManageParamDao extends BaseMapper<ManageParamEntity> {
    @SuppressWarnings("all")
    List<ManageParamEntity> getList(Map<String, Object> params);

    int removeByGroupIds(@Param("groupIds") Long[] groupIds);
}
