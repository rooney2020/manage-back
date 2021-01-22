package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageProjectEntity> page = this.page(
                new Query<ManageProjectEntity>().getPage(params),
                new QueryWrapper<ManageProjectEntity>()
        );

        return new PageUtils(page);
    }

}
