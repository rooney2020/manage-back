package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageFeedbackDao;
import io.renren.modules.manage.entity.ManageFeedbackEntity;
import io.renren.modules.manage.service.ManageFeedbackService;


@Service("manageFeedbackService")
public class ManageFeedbackServiceImpl extends ServiceImpl<ManageFeedbackDao, ManageFeedbackEntity> implements ManageFeedbackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageFeedbackEntity> page = this.page(
                new Query<ManageFeedbackEntity>().getPage(params),
                new QueryWrapper<ManageFeedbackEntity>()
        );

        return new PageUtils(page);
    }

}
