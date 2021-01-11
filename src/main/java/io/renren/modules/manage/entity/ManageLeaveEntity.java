package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 请假信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Data
@TableName("manage_leave")
public class ManageLeaveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	private Long leaveId;
	/**
	 * 请假人id
	 */
	private Long userId;
	/**
	 * 批准人id
	 */
	private Long approveId;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 批准时间
	 */
	private String approveTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 0：创建，1：批准，2：拒绝
	 */
	private Integer status;
	/**
	 * 0：带薪假，1：病假，2：无薪假，3：事假，4：年假，5：居家办公
	 */
	private Integer leaveType;

}
