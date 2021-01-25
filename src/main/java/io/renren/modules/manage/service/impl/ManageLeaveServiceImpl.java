package io.renren.modules.manage.service.impl;

import io.renren.modules.manage.dao.ManageParamDao;
import io.renren.modules.manage.entity.ManageParamEntity;
import io.renren.modules.manage.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageLeaveDao;
import io.renren.modules.manage.entity.ManageLeaveEntity;
import io.renren.modules.manage.service.ManageLeaveService;


@Service("manageLeaveService")
public class ManageLeaveServiceImpl extends ServiceImpl<ManageLeaveDao, ManageLeaveEntity> implements ManageLeaveService {

    @Autowired
    private ManageLeaveDao dao;
    @Autowired
    private ManageParamDao paramDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageLeaveEntity> page = this.page(
                new Query<ManageLeaveEntity>().getPage(params),
                new QueryWrapper<ManageLeaveEntity>().lambda()
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
        List<ManageLeaveEntity> list = dao.getList(params);
        int totalCount = dao.getListSize(params);
        PageUtils page = new PageUtils(list, totalCount, pageSize, currPage);
        return page;
    }

    @Override
    public List<Map<String, Object>> personal(Long userId) {
        List<ManageParamEntity> list = paramDao.getParamList("LEAVE_TYPE");
        List<ManageParamEntity> params = paramDao.getParamList("LEAVE_MANAGE");
        Map<String, Object> personal = dao.personal(userId, list);
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(2);
        for (ManageParamEntity param : params) {
            map = new HashMap<>(2);
            map.put("key", param.getRemark());
            if (null != personal) {
                map.put("value", Integer.parseInt(param.getParamValue()) - Integer.parseInt(String.valueOf(personal.getOrDefault(param.getParamName(), 0))));
            } else {
                map.put("value", Integer.parseInt(param.getParamValue()));
            }
            map.put("original", Integer.parseInt(param.getParamValue()));
            result.add(map);
        }
        return result;
    }

    @Override
    public PageUtils history(Map<String, Object> params, Long userId) {
        IPage<ManageLeaveEntity> page = this.page(
                new Query<ManageLeaveEntity>().getPage(params),
                new QueryWrapper<ManageLeaveEntity>().lambda()
                .eq(ManageLeaveEntity::getUserId, userId)
        );

        return new PageUtils(page);
    }
}
