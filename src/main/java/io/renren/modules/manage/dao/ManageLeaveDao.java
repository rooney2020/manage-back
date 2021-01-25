package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManageLeaveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.manage.entity.ManageParamEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 请假信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Mapper
public interface ManageLeaveDao extends BaseMapper<ManageLeaveEntity> {

    Map<String, Object> personal(@Param("userId") Long userId, @Param("list") List<ManageParamEntity> list);

    List<ManageLeaveEntity> getList(Map<String, Object> params);
    int getListSize(Map<String, Object> params);
}
