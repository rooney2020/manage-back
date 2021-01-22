package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	private Long projectId;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 负责人id
	 */
	private Long managerId;
	/**
	 * 开始日期
	 */
	private Date beginDate;
	/**
	 * 结束日期
	 */
	private Date endDate;
	/**
	 * 总工时
	 */
	private Integer totalCount;
	/**
	 * 备注
	 */
	private String comment;
	/**
	 * 创建人
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 状态0：未开始，1：进行中，2：已完成，3：已关闭
	 */
	private Integer status;

}
