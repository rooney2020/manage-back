package io.renren.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.manage.entity.ManagePunchEntity;

import java.util.Map;

/**
 * 打卡签到表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
public interface ManagePunchService extends IService<ManagePunchEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

