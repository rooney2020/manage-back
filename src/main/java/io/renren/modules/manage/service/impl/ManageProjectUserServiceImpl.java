package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageProjectUserDao;
import io.renren.modules.manage.entity.ManageProjectUserEntity;
import io.renren.modules.manage.service.ManageProjectUserService;


@Service("manageProjectUserService")
public class ManageProjectUserServiceImpl extends ServiceImpl<ManageProjectUserDao, ManageProjectUserEntity> implements ManageProjectUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageProjectUserEntity> page = this.page(
                new Query<ManageProjectUserEntity>().getPage(params),
                new QueryWrapper<ManageProjectUserEntity>()
        );

        return new PageUtils(page);
    }

}
