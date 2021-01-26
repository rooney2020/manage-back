package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageMessageDao;
import io.renren.modules.manage.entity.ManageMessageEntity;
import io.renren.modules.manage.service.ManageMessageService;


@Service("manageMessageService")
public class ManageMessageServiceImpl extends ServiceImpl<ManageMessageDao, ManageMessageEntity> implements ManageMessageService {

    @Autowired
    private ManageMessageDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long userId, Integer isRead) {
        IPage<ManageMessageEntity> page = this.page(
                new Query<ManageMessageEntity>().getPage(params),
                new QueryWrapper<ManageMessageEntity>().lambda()
                .eq(ManageMessageEntity::getMsTo, userId)
                .eq(isRead != null, ManageMessageEntity::getIsRead, isRead)
        );

        return new PageUtils(page);
    }

    @Override
    public IPage<ManageMessageEntity> selectUserPage(Page<ManageMessageEntity> page, Long userId, Integer isRead) {
        return dao.selectPageVo(page, userId, isRead);
    }

}
