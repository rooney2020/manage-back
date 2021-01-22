package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DealGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 参数表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Data
@TableName("manage_param")
public class ManageParamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableField(exist = false)
	private Integer uuid;
	/**
	 * 自增主键
	 */
	@TableId
	@NotNull(message="参数id不能为空", groups = {UpdateGroup.class})
	private Long paramId;

	/**
	 * 所属参数组id
	 */
	@NotNull(message="参数组id不能为空", groups = {AddGroup.class, UpdateGroup.class, DealGroup.class})
	private Long groupId;

	/**
	 * 参数名
	 */
	@NotBlank(message="参数名不能为空", groups = {AddGroup.class, UpdateGroup.class, DealGroup.class})
	private String paramName;

	/**
	 * 参数值
	 */
	@NotBlank(message="参数值不能为空", groups = {AddGroup.class, UpdateGroup.class, DealGroup.class})
	private String paramValue;

	/**
	 * 备注
	 */
	@NotBlank(message="备注不能为空", groups = {DealGroup.class})
	private String remark;

}
