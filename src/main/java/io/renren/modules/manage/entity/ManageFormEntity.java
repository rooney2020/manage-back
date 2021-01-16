package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 自主填报-动态表单
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:55
 */
@Data
@TableName("manage_form")
public class ManageFormEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 表单id
	 */
	@TableId
	private Long formId;
	/**
	 * 所在省市区id
	 */
	@NotBlank(message = "所在省市区id不能为空", groups = {AddGroup.class, DealGroup.class})
	private String provId;
	/**
	 * 是否到访过，0：否，1：是
	 */
	@NotNull(message = "是否到访过疫情地区不能为空", groups = {AddGroup.class, DealGroup.class})
	@Min(value = 0, message = "非法参数：是否到访过疫情地区", groups = {AddGroup.class, DealGroup.class})
	@Max(value = 1, message = "非法参数：是否到访过疫情地区", groups = {AddGroup.class, DealGroup.class})
	private Integer isVisit;
	/**
	 * 到访省市区
	 */
	@NotBlank(message = "到访省市区不能为空", groups = {DealGroup.class})
	private String visitProv;
	/**
	 * 身体状况，0：发烧感冒，1：一切正常
	 */
	@NotBlank(message = "身体状况不能为空", groups = {DealGroup.class})
	@Min(value = 0, message = "非法参数：身体状况", groups = {DealGroup.class})
	@Max(value = 1, message = "非法参数：身体状况", groups = {DealGroup.class})
	private Integer healthStatus;
	/**
	 * 工作状态，0：在家隔离，1：正常上班，2请假休假
	 */
	@NotBlank(message = "工作状态不能为空", groups = {DealGroup.class})
	@Min(value = 0, message = "非法参数：工作状态", groups = {DealGroup.class})
	@Max(value = 2, message = "非法参数：工作状态", groups = {DealGroup.class})
	private Integer workStatus;
	/**
	 * 工作地点
	 */
	@NotBlank(message = "工作地点不能为空", groups = {DealGroup.class})
	private String workPlace;
	/**
	 * 接触同事范围
	 */
	@NotBlank(message = "接触同事范围不能为空", groups = {DealGroup.class})
	private String workmateRange;
	/**
	 * 后续安排，0：自我隔离，1：预约核酸检测，2：等待核酸结果
	 */
	@NotBlank(message = "后续安排不能为空", groups = {DealGroup.class})
	@Min(value = 0, message = "非法参数：后续安排", groups = {DealGroup.class})
	@Max(value = 2, message = "非法参数：后续安排", groups = {DealGroup.class})
	private Integer arrangement;
	/**
	 * 填报时间
	 */
	@NotNull(message = "填报时间不能为空", groups = {AddGroup.class, DealGroup.class})
	private Date etlTime;
	/**
	 * 填报人id
	 */
	@NotNull(message = "填报人id不能为空", groups = {AddGroup.class, DealGroup.class})
	private Long userId;
}
