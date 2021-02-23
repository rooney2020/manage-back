package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageProjectEntity;
import io.renren.modules.manage.entity.ManageTaskEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 项目任务表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Mapper
public interface ManageTaskDao extends BaseMapper<ManageTaskEntity> {

    List<ManageTaskEntity> getRequirements();

    IPage<ManageTaskEntity> getList(Page<ManageTaskEntity> ipage, @Param("userId") Long userId, @Param("params") Map<String, Object> params);
}
