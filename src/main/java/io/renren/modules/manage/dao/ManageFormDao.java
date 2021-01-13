package io.renren.modules.manage.dao;

import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManageFormEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 自主填报-动态表单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:55
 */
@Mapper
public interface ManageFormDao extends BaseMapper<ManageFormEntity> {


}
