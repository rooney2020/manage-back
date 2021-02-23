package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.manage.entity.ManageProjectEntity;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageTaskDao;
import io.renren.modules.manage.entity.ManageTaskEntity;
import io.renren.modules.manage.service.ManageTaskService;


@Service("manageTaskService")
public class ManageTaskServiceImpl extends ServiceImpl<ManageTaskDao, ManageTaskEntity> implements ManageTaskService {

    @Autowired
    private ManageTaskDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageTaskEntity> page = this.page(
                new Query<ManageTaskEntity>().getPage(params),
                new QueryWrapper<ManageTaskEntity>().lambda()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ManageTaskEntity> getRequirements() {
        return dao.getRequirements();
    }

    @Override
    public IPage<ManageTaskEntity> getList(Page<ManageTaskEntity> ipage, Long userId, Map<String, Object> params) {
        return dao.getList(ipage, userId, params);
    }

    @Override
    public List<ManageTaskRecordEntity> worktime(Long taskId) {
        return dao.worktime(taskId);
    }
}
