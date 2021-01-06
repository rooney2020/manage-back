package io.renren.modules.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.manage.entity.ManageNewsEntity;
import io.renren.modules.manage.mapper.ManageNewsMapper;
import io.renren.modules.manage.service.ManageNewsService;
import org.springframework.stereotype.Service;

@Service("manageNewsService")
public class ManageNewsServiceImpl extends ServiceImpl<ManageNewsMapper, ManageNewsEntity> implements ManageNewsService {

}
