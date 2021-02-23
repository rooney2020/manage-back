package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 请修改注释
 *
 * @author zhaoliyuan
 * @date 2021.02.23
 */
@Data
@TableName("manage_task_record")
public class ManageTaskRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId
    @NotNull(message = "ID不能为空", groups = {UpdateGroup.class})
    private Long recordId;

    @NotNull(message = "任务号不能为空", groups = {UpdateGroup.class, AddGroup.class})
    private Long taskId;
    @TableField(exist = false)
    private String taskName;

    /**
     * 日期
     */
    @NotNull(message = "日期不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recordDate;

    /**
     * 消耗时间
     */
    @NotNull(message = "消耗时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Double consume;
    /**
     * 剩余时间
     */
    @NotNull(message = "剩余时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Double remain;


    @NotBlank(message = "备注不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String remark;
    /**
     * 创建人id
     */
    @NotNull(message = "创建人不能为空", groups = {AddGroup.class})
    private Long createUserId;
    @TableField(exist = false)
    private String createUserName;

    /**
     * 创建时间
     */
    @NotNull(message = "创建时间不能为空", groups = {AddGroup.class})
    private Date createTime;
}
