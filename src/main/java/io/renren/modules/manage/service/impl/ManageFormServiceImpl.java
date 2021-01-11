package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageFormDao;
import io.renren.modules.manage.entity.ManageFormEntity;
import io.renren.modules.manage.service.ManageFormService;


@Service("manageFormService")
public class ManageFormServiceImpl extends ServiceImpl<ManageFormDao, ManageFormEntity> implements ManageFormService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageFormEntity> page = this.page(
                new Query<ManageFormEntity>().getPage(params),
                new QueryWrapper<ManageFormEntity>()
        );

        return new PageUtils(page);
    }

}
