package io.renren.modules.manage.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
    * 新闻表
    */
@Data
public class ManageNewsEntity {

    private Long newsId;

    /**
    * 新闻标题
    */
    private String title;

    /**
    * 图片地址
    */
    private String imageUrl;

    /**
    * 新闻内容
    */
    private String content;

    /**
    * 0：启用，1：删除
    */
    private Integer isActive;

    /**
    * 创建者ID
    */
    private Long createUserId;

    /**
    * 创建时间
    */
    private Date createTime;
}
