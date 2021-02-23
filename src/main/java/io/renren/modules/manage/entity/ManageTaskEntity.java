package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 项目任务表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Data
@TableName("manage_task")
public class ManageTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	@NotNull(message = "ID不能为空", groups = {UpdateGroup.class, DealGroup.class})
	private Long taskId;
	/**
	 * 项目id
	 */
	@NotNull(message = "项目ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Long projectId;
	@TableField(exist = false)
	private String projectName;
	/**
	 * 任务名称
	 */
	@NotBlank(message = "任务名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String taskName;
	/**
	 * 状态0：未开始，1：进行中，2：已完成，3：已关闭
	 */
	@Min(0)
	@Max(3)
	@NotNull(message = "状态不能为空", groups = {AddGroup.class, UpdateGroup.class, DealGroup.class})
	private Integer status;
	/**
	 * 指派给
	 */
	@NotNull(message = "指派人不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Long assigneeId;
	@TableField(exist = false)
	private String assignName;
	/**
	 * 完成者
	 */
	private Long completeUserId;
	@TableField(exist = false)
	private String completeName;
	/**
	 * 预计
	 */
	@NotNull(message = "预计消耗时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Double estimate;
	/**
	 * 已消耗
	 */
	@TableField(exist = false)
	private Double usedTime;
	/**
	 * 截止日期
	 */
	@NotNull(message = "截止日期不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date endDate;
	/**
	 * 相关需求
	 */
	private Long relatedTaskId;
	@TableField(exist = false)
	private String relatedTaskName;
	/**
	 * 创建人id
	 */
	@NotNull(message = "创建人不能为空", groups = {AddGroup.class})
	private Long createUserId;
	@TableField(exist = false)
	private String createUserName;
	/**
	 * 开始时间
	 */
	@NotNull(message = "开始时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date beginDate;
	/**
	 * 创建时间
	 */
	@NotNull(message = "创建时间不能为空", groups = {AddGroup.class})
	private Date createTime;
	/**
	 * 实际开始时间
	 */
	private Date realBeginDate;
	/**
	 * 完成时间
	 */
	private Date finishDate;
	/**
	 * 任务类型0：需求，1：前端开发，2：后端开发，3：其他
	 */
	@NotNull(message = "任务类型不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer taskType;
	/**
	 * 任务描述
	 */
	@NotBlank(message = "任务描述不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String comment;

}
