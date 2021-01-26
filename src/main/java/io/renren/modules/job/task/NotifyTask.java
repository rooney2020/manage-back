package io.renren.modules.job.task;

import io.renren.modules.manage.dao.ManageMessageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 请修改注释
 *
 * @author zhaoliyuan
 * @date 2021.01.26
 */
@Component("notifyTask")
public class NotifyTask implements ITask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ManageMessageDao dao;

    @Override
    public void run(String params){
        logger.debug("notifyTask定时任务正在执行，参数为：{}", params);
        dao.notifyAllPunch(params + "时间到了！");
    }
}
