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
        String status = (String) params.get("status");
        String userId = (String) params.get("userId");
        String resolveUserId = (String) params.get("resolveUserId");
        IPage<ManageFeedbackEntity> page = this.page(
                new Query<ManageFeedbackEntity>().getPage(params),
                new QueryWrapper<ManageFeedbackEntity>().lambda()
                        .eq(status != null && !"".equals(status), ManageFeedbackEntity::getStatus, status)
                        .eq(userId != null && !"".equals(userId), ManageFeedbackEntity::getUserId, userId)
                        .eq(resolveUserId != null && !"".equals(resolveUserId), ManageFeedbackEntity::getResolveUserId, resolveUserId)
        );

        return new PageUtils(page);
    }

}
