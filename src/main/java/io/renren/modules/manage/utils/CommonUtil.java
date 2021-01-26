package io.renren.modules.manage.utils;

import io.renren.modules.manage.entity.ManageMessageEntity;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 请修改注释
 *
 * @author zhaoliyuan
 * @date 2021.01.13
 */
public class CommonUtil {
    public static boolean isEmpty(String str) {
        return str != null && !"".equals(str);
    }

    public static Integer uuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 删除uuid中的"-"
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        // 获取uuid 的hashcode
        int a = uuid.hashCode();
        // hashcode 的绝对值 因为uuid的hashcode可能为负数
        return Math.abs(a);
    }

    public static ManageMessageEntity msg(Long from, Long to, String content) {
        ManageMessageEntity entity = new ManageMessageEntity();
        entity.setMsFrom(from);
        entity.setMsTo(to);
        entity.setMsContent(content);
        entity.setCreateTime(new Date());
        entity.setIsRead(0);
        return entity;
    }
}
