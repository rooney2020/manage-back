package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	private Long taskId;
	/**
	 * 项目id
	 */
	private Long projectId;
	/**
	 * 任务名称
	 */
	private String taskName;
	/**
	 * 状态0：未开始，1：进行中，2：已完成，3：已关闭
	 */
	private Integer status;
	/**
	 * 指派给
	 */
	private Long assigneeId;
	/**
	 * 完成者
	 */
	private Long completeUserId;
	/**
	 * 预计
	 */
	private Integer estimate;
	/**
	 * 已消耗
	 */
	private Integer usedTime;
	/**
	 * 截止日期
	 */
	private Date endDate;
	/**
	 * 相关需求
	 */
	private Long relatedTaskId;
	/**
	 * 开始时间
	 */
	private Date beginDate;
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
	private Integer taskType;
	/**
	 * 任务描述
	 */
	private String comment;

}
