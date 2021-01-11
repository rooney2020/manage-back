package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageParamGroupDao;
import io.renren.modules.manage.entity.ManageParamGroupEntity;
import io.renren.modules.manage.service.ManageParamGroupService;


@Service("manageParamGroupService")
public class ManageParamGroupServiceImpl extends ServiceImpl<ManageParamGroupDao, ManageParamGroupEntity> implements ManageParamGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageParamGroupEntity> page = this.page(
                new Query<ManageParamGroupEntity>().getPage(params),
                new QueryWrapper<ManageParamGroupEntity>()
        );

        return new PageUtils(page);
    }

}
