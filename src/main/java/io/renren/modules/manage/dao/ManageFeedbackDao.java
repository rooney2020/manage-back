package io.renren.modules.manage.dao;

import io.renren.modules.manage.entity.ManageFeedbackEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 反馈信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:55
 */
@Mapper
public interface ManageFeedbackDao extends BaseMapper<ManageFeedbackEntity> {

}
