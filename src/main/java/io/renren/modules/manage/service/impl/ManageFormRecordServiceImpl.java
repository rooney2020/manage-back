package io.renren.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.manage.dao.ManageFormRecordDao;
import io.renren.modules.manage.entity.ManageFormRecordEntity;
import io.renren.modules.manage.service.ManageFormRecordService;


@Service("manageFormRecordService")
public class ManageFormRecordServiceImpl extends ServiceImpl<ManageFormRecordDao, ManageFormRecordEntity> implements ManageFormRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ManageFormRecordEntity> page = this.page(
                new Query<ManageFormRecordEntity>().getPage(params),
                new QueryWrapper<ManageFormRecordEntity>()
        );

        return new PageUtils(page);
    }

}
