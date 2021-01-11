package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 自主填报-动态表单-记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Data
@TableName("manage_form_record")
public class ManageFormRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录id
	 */
	@TableId
	private Long recordId;
	/**
	 * 表单id,关联【表单】表主键
	 */
	private Long formId;
	/**
	 * 记录json，格式例如：{"姓名": "张三", "年龄": 18}
	 */
	private String recordJson;
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
