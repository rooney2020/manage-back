package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.manage.dao.ManageFormDao;
import io.renren.modules.manage.entity.ManageFormEntity;
import io.renren.modules.manage.service.ManageFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("manageFormService")
public class ManageFormServiceImpl extends ServiceImpl<ManageFormDao, ManageFormEntity> implements ManageFormService {

    @Autowired
    private ManageFormDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageFormEntity> page = this.page(
                new Query<ManageFormEntity>().getPage(params),
                new QueryWrapper<ManageFormEntity>().lambda()
        );

        return new PageUtils(page);
    }

    @Override
    public IPage<ManageFormEntity> selectUserPage(Page<ManageFormEntity> ipage, Map<String, Object> params) {
        return dao.selectUserPage(ipage, params);
    }
}
