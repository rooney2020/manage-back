package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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

	/**
	 * 自增主键
	 */
	@TableId
	private Long paramId;
	/**
	 * 所属参数组id
	 */
	private Long groupId;
	/**
	 * 参数名
	 */
	private String paramName;
	/**
	 * 参数值
	 */
	private String paramValue;
	/**
	 * 备注
	 */
	private String remark;

}
