package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManagePunchEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

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

    IPage<Map> selectUserPage(Page<Map> ipage, @Param("userId") Long userId, @Param("date") String date);
}
