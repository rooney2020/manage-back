package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageProjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目信息
 */
@Mapper
public interface ManageProjectDao extends BaseMapper<ManageProjectEntity> {

    IPage<ManageProjectEntity> selectUserPage(Page<ManageProjectEntity> ipage, @Param("userId") Long userId, @Param("params") Map<String, Object> params);

    List<ManageProjectEntity> getAllProjects();
}
