package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

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
	@NotNull(message="假条id不能为空", groups = {UpdateGroup.class})
	private Long leaveId;
	/**
	 * 请假人id
	 */
	@NotNull(message="请假人id不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Long userId;
	/**
	 * 处理人id
	 */
	@NotNull(message="处理人id不能为空", groups = {DealGroup.class})
	private Long dealId;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@NotNull(message="开始时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Date beginTime;
	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@NotNull(message="结束时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Date endTime;
	/**
	 * 处理时间
	 */
	@NotNull(message="处理时间不能为空", groups = {DealGroup.class})
	private Date etlTime;
	/**
	 * 创建时间
	 */
	@NotNull(message="创建时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Date createTime;
	/**
	 * 0：创建，1：批准，2：拒绝
	 */
	@NotNull(message="请假状态不能为空", groups = {AddGroup.class, UpdateGroup.class, DealGroup.class})
	@Min(0)
	@Max(2)
	private Integer status;
	/**
	 * 0：带薪假，1：病假，2：无薪假，3：事假，4：年假，5：居家办公
	 */
	@NotNull(message="请假类型不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer leaveType;
	/**
	 * 总请假工时
	 */
	@NotNull(message="总请假工时不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer totalCount;
}
