package io.renren.modules.manage.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 消息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-25 11:52:59
 */
@Mapper
public interface ManageMessageDao extends BaseMapper<ManageMessageEntity> {
    int notifyAllPunch(@Param("content") String content);

    IPage<ManageMessageEntity> selectPageVo(Page<ManageMessageEntity> page, @Param("userId") Long userId, @Param("isRead") Integer isRead);
}
