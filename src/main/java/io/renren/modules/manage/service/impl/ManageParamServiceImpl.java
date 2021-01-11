package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageParamDao;
import io.renren.modules.manage.entity.ManageParamEntity;
import io.renren.modules.manage.service.ManageParamService;


@Service("manageParamService")
public class ManageParamServiceImpl extends ServiceImpl<ManageParamDao, ManageParamEntity> implements ManageParamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageParamEntity> page = this.page(
                new Query<ManageParamEntity>().getPage(params),
                new QueryWrapper<ManageParamEntity>()
        );

        return new PageUtils(page);
    }

}
