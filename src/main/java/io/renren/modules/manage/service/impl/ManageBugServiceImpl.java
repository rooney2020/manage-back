package io.renren.modules.manage.service.impl;

import io.renren.modules.manage.entity.ManageTaskEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageBugDao;
import io.renren.modules.manage.entity.ManageBugEntity;
import io.renren.modules.manage.service.ManageBugService;


@Service("manageBugService")
public class ManageBugServiceImpl extends ServiceImpl<ManageBugDao, ManageBugEntity> implements ManageBugService {

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long projectId) {
        IPage<ManageBugEntity> page = this.page(
                new Query<ManageBugEntity>().getPage(params),
                new QueryWrapper<ManageBugEntity>().lambda()
                        .eq(projectId != null, ManageBugEntity::getProjectId, projectId)
        );

        return new PageUtils(page);
    }

}
