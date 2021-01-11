package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	 * 部门id
	 */
	private Long deptId;
	/**
	 * 表单名称
	 */
	private String formName;
	/**
	 * 排序
	 */
	private Long sort;
	/**
	 * 发布标记（0：待发布；1：发布中；2：截止）
	 */
	private String sendFlag;
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
	 *
	 */
	private Date updateTime;
	/**
	 * 删除标志（0：未删除 1：已删除）
	 */
	private String delFlag;

}
