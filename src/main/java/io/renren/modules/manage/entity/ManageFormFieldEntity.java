package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 自主填报-动态表单-字段
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Data
@TableName("manage_form_field")
public class ManageFormFieldEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字段id
	 */
	@TableId
	private Long fieldId;
	/**
	 * 表单id，关联【表单】表主键
	 */
	private Long formId;
	/**
	 * 字段名称
	 */
	private String fieldName;
	/**
	 * 是否必填（0：必填；1：非必填）
	 */
	private String isRequired;
	/**
	 * 字段类型（关联系统字典表，1：单行文本，2：文本域，3：单选，4：多选，5：日期，6：下拉框）
	 */
	private String fieldType;
	/**
	 * 字段选项（若字段类型为3、4、6，则该字段必填，用“,”连接各个选项）
	 */
	private String fieldOption;
	/**
	 * 字段选项值（若字段类型为3、4、6，则该字段必填，用“,”连接各个选项值）
	 */
	private String fieldOptionVal;
	/**
	 * 字段默认值（若字段类型为3、4、6，如有默认值，则该字段需用","连接各个选项值作为默认值）
	 */
	private String fieldDefault;
	/**
	 * 是否查询显示（0：不显示；1：显示）
	 */
	private String isQueryDisplay;
	/**
	 * 排序
	 */
	private Long sort;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建者
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新者
	 */
	private String updateBy;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 删除标志（0：未删除 1：已删除）
	 */
	private String delFlag;

}
