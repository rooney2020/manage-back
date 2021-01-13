package io.renren.modules.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private ManageParamDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageParamEntity> page = this.page(
                new Query<ManageParamEntity>().getPage(params),
                new QueryWrapper<ManageParamEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getList(Map<String, Object> params) {
        int currPage = Integer.parseInt((String) params.get("page"));
        int pageSize = Integer.parseInt((String) params.get("limit"));
        if (params.containsKey("page") && params.containsKey("limit")) {
            params.put("page", (currPage - 1) * pageSize);
            params.put("limit", pageSize);
        }
        List<ManageParamEntity> list = dao.getList(params);
        int totalCount = list.size();
        PageUtils page = new PageUtils(list, totalCount, pageSize, currPage);
        return page;
    }

}
