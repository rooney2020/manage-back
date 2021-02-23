package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.renren.modules.sys.entity.SysUserEntity;
import lombok.Data;

/**
 * 消息表
 */
@Data
@TableName("manage_message")
public class ManageMessageEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键，消息id
     */
    @TableId
    private Long msId;
    /**
     * 消息内容
     */
    private String msContent;
    /**
     * 发送者
     */
    private Long msFrom;
    @TableField(exist = false)
    private SysUserEntity msFromUser;
    /**
     * 接收者
     */
    private Long msTo;
    @TableField(exist = false)
    private SysUserEntity msToUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否已读0：未读，1：已读
     */
    private Integer isRead;

}
