package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManagePunchEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 打卡签到表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Mapper
public interface ManagePunchDao extends BaseMapper<ManagePunchEntity> {

    ManagePunchEntity getStatus(@Param("userId") Long userId, @Param("type") Integer type);
}
