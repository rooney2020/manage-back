package io.renren.modules.manage.service.impl;

import io.renren.modules.manage.utils.CommonUtil;
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
        Integer currPage = 1;
        Integer pageSize = 10;
        if (params.containsKey("page") && params.containsKey("limit")) {
            if (CommonUtil.isEmpty((String) params.get("page")) && CommonUtil.isEmpty((String) params.get("limit"))) {
                currPage = Integer.parseInt((String) params.get("page"));
                pageSize = Integer.parseInt((String) params.get("limit"));

            }
        }
        params.put("page", (currPage - 1) * pageSize);
        params.put("limit", pageSize);
        List<ManageParamEntity> list = dao.getList(params);
        int totalCount = dao.getListSize(params);
        PageUtils page = new PageUtils(list, totalCount, pageSize, currPage);
        return page;
    }

    @Override
    public int removeByGroupIds(Long[] groupIds) {
        return dao.removeByGroupIds(groupIds);
    }

}
