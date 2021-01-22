package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageTaskEntity> page = this.page(
                new Query<ManageTaskEntity>().getPage(params),
                new QueryWrapper<ManageTaskEntity>()
        );

        return new PageUtils(page);
    }

}
