package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManagePunchDao;
import io.renren.modules.manage.entity.ManagePunchEntity;
import io.renren.modules.manage.service.ManagePunchService;


@Service("managePunchService")
public class ManagePunchServiceImpl extends ServiceImpl<ManagePunchDao, ManagePunchEntity> implements ManagePunchService {

    @Autowired
    private ManagePunchDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManagePunchEntity> page = this.page(
                new Query<ManagePunchEntity>().getPage(params),
                new QueryWrapper<ManagePunchEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public ManagePunchEntity getStatus(Long userId, Integer type) {
        return dao.getStatus(userId, type);
    }

    @Override
    public IPage<Map> selectUserPage(Page<Map> ipage, Long userId, String date) {
        return dao.selectUserPage(ipage, userId, date);
    }

}
