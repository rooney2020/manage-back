package io.renren.modules.manage.service.impl;

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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManagePunchEntity> page = this.page(
                new Query<ManagePunchEntity>().getPage(params),
                new QueryWrapper<ManagePunchEntity>()
        );

        return new PageUtils(page);
    }

}
