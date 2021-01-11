package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageFormSearchDao;
import io.renren.modules.manage.entity.ManageFormSearchEntity;
import io.renren.modules.manage.service.ManageFormSearchService;


@Service("manageFormSearchService")
public class ManageFormSearchServiceImpl extends ServiceImpl<ManageFormSearchDao, ManageFormSearchEntity> implements ManageFormSearchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageFormSearchEntity> page = this.page(
                new Query<ManageFormSearchEntity>().getPage(params),
                new QueryWrapper<ManageFormSearchEntity>()
        );

        return new PageUtils(page);
    }

}
