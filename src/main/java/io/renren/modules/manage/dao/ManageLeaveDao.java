package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManageLeaveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 请假信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Mapper
public interface ManageLeaveDao extends BaseMapper<ManageLeaveEntity> {

}
