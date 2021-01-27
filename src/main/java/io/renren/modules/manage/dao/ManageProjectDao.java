package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageProjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Mapper
public interface ManageProjectDao extends BaseMapper<ManageProjectEntity> {

    IPage<ManageProjectEntity> selectUserPage(Page<ManageProjectEntity> ipage, Long userId);
}
