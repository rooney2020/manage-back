package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.manage.entity.ManageNewsEntity;
import io.renren.modules.manage.dao.ManageNewsDao;
import io.renren.modules.manage.service.ManageNewsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("manageNewsService")
public class ManageNewsServiceImpl extends ServiceImpl<ManageNewsDao, ManageNewsEntity> implements ManageNewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String title = (String) params.get("title");

        IPage<ManageNewsEntity> page = this.page(
                new Query<ManageNewsEntity>().getPage(params),
                new QueryWrapper<ManageNewsEntity>()
                        .like(StringUtils.isNotBlank(title), "title", title)
        );

        return new PageUtils(page);
    }

}
