package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 自主填报-动态表单-记录搜索
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Data
@TableName("manage_form_search")
public class ManageFormSearchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long searchId;
	/**
	 * 表单id，关联【表单】表主键
	 */
	private Long formId;
	/**
	 * 记录id,关联【表单记录】表主键
	 */
	private Long recordId;
	/**
	 * 字段id,关联【表单字段】表主键
	 */
	private Long fieldId;
	/**
	 * 字段值,若通过field_id查得字段类型为4，该值为用“,”连接的各个选项值
	 */
	private String fieldVal;
	/**
	 * 排序
	 */
	private Long sort;
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
