package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 新闻表
 */
@Data
@TableName("manage_news")
public class ManageNewsEntity {

    /**
     * 新闻id
     */
    @TableId
    @NotNull(message = "新闻id不能为空", groups = {UpdateGroup.class})
    private Long newsId;

    /**
     * 新闻标题
     */
    @NotBlank(message = "标题不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String title;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 新闻内容
     */
    @NotBlank(message = "内容不能为空", groups = {AddGroup.class, UpdateGroup.class})
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
