package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 反馈信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:55
 */
@Data
@TableName("manage_feedback")
public class ManageFeedbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 反馈id
	 */
	@TableId
	private Long feedId;
	/**
	 * 反馈人id
	 */
	private Long userId;
	/**
	 * 反馈人手机号
	 */
	private String mobile;
	/**
	 * 反馈内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 0：未处理，1：已处理
	 */
	private Integer status;
	/**
	 * 处理人id
	 */
	private Long resolveUserId;
	/**
	 * 处理时间
	 */
	private Date etlTime;

}
