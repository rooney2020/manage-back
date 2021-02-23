package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageFormEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 自主填报
 */
@Mapper
public interface ManageFormDao extends BaseMapper<ManageFormEntity> {


    IPage<ManageFormEntity> selectUserPage(Page<ManageFormEntity> ipage, Map<String, Object> params);
}
