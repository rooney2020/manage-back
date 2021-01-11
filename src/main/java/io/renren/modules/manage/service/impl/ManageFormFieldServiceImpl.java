package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageFormFieldDao;
import io.renren.modules.manage.entity.ManageFormFieldEntity;
import io.renren.modules.manage.service.ManageFormFieldService;


@Service("manageFormFieldService")
public class ManageFormFieldServiceImpl extends ServiceImpl<ManageFormFieldDao, ManageFormFieldEntity> implements ManageFormFieldService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageFormFieldEntity> page = this.page(
                new Query<ManageFormFieldEntity>().getPage(params),
                new QueryWrapper<ManageFormFieldEntity>()
        );

        return new PageUtils(page);
    }

}
