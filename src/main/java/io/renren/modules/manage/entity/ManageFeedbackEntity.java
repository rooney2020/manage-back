package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 反馈信息表
 */
@Data
@TableName("manage_feedback")
public class ManageFeedbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 反馈id
     */
    @TableId
    @NotNull(message = "反馈id不能为空", groups = {UpdateGroup.class})
    private Long feedId;
    /**
     * 反馈人id
     */
    @NotNull(message = "反馈人id不能为空", groups = {AddGroup.class})
    private Long userId;
    /**
     * 反馈人手机号
     */
    @NotBlank(message = "反馈人手机号不能为空", groups = {AddGroup.class})
    private String mobile;
    /**
     * 反馈内容
     */
    @NotBlank(message = "反馈内容不能为空", groups = {AddGroup.class})
    private String content;
    /**
     * 创建时间
     */
    @NotNull(message = "创建时间不能为空", groups = {AddGroup.class})
    private Date createTime;
    /**
     * 0：未处理，1：已处理
     */
    @NotNull(message = "处理状态不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Integer status;
    /**
     * 处理人id
     */
    @NotNull(message = "处理人id不能为空", groups = {UpdateGroup.class})
    private Long resolveUserId;
    /**
     * 处理时间
     */
    @NotNull(message = "处理时间不能为空", groups = {UpdateGroup.class})
    private Date etlTime;
    /**
     * 处理意见
     */
    @NotBlank(message = "处理意见不能为空", groups = {UpdateGroup.class})
    private String resolveContent;
}
