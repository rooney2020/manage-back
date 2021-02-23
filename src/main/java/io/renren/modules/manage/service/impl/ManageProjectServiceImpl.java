package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageProjectDao;
import io.renren.modules.manage.entity.ManageProjectEntity;
import io.renren.modules.manage.service.ManageProjectService;


@Service("manageProjectService")
public class ManageProjectServiceImpl extends ServiceImpl<ManageProjectDao, ManageProjectEntity> implements ManageProjectService {

    @Autowired
    private ManageProjectDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageProjectEntity> page = this.page(
                new Query<ManageProjectEntity>().getPage(params),
                new QueryWrapper<ManageProjectEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public IPage<ManageProjectEntity> selectUserPage(Page<ManageProjectEntity> ipage, Long userId, Map<String, Object> params) {
        return dao.selectUserPage(ipage, userId, params);
    }
    @Override
    public List<ManageProjectEntity> getAllProjects() {
        return dao.getAllProjects();
    }

}
