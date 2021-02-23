package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 项目信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Data
@TableName("manage_project")
public class ManageProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	@NotNull(message = "ID不能为空", groups = {UpdateGroup.class})
	private Long projectId;
	/**
	 * 项目名称
	 */
	@NotBlank(message = "项目名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String projectName;
	/**
	 * 负责人id
	 */
	@NotNull(message = "负责人不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Long managerId;
	@TableField(exist = false)
	private String managerName;
	/**
	 * 开始日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@NotNull(message = "开始日期不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Date beginDate;
	/**
	 * 结束日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@NotNull(message = "结束日期不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Date endDate;
	/**
	 * 总工时
	 */
	@NotNull(message = "总工时不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Double totalCount;
	/**
	 * 备注
	 */
	@NotBlank(message = "备注不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String comment;
	/**
	 * 创建人
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
	/**
	 * 更新时间
	 */
	@NotNull(message = "更新时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Date updateTime;
	/**
	 * 状态0：未开始，1：进行中，2：已完成，3：已关闭
	 */
	@NotNull(message = "状态不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private Integer status;

}
