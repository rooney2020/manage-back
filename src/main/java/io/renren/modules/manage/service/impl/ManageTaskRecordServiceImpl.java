package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.manage.dao.ManageTaskDao;
import io.renren.modules.manage.dao.ManageTaskRecordDao;
import io.renren.modules.manage.entity.ManageTaskRecordEntity;
import io.renren.modules.manage.service.ManageTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("manageTaskRecordService")
public class ManageTaskRecordServiceImpl extends ServiceImpl<ManageTaskRecordDao, ManageTaskRecordEntity> implements ManageTaskRecordService {

    @Autowired
    private ManageTaskDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageTaskRecordEntity> page = this.page(
                new Query<ManageTaskRecordEntity>().getPage(params),
                new QueryWrapper<ManageTaskRecordEntity>().lambda()
        );

        return new PageUtils(page);
    }
}
