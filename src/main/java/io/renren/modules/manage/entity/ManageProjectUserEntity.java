package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目成员表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Data
@TableName("manage_project_user")
public class ManageProjectUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 项目id
	 */
	@TableId
	private Long projectId;
	/**
	 * 用户id
	 */
	private Long userId;

}
