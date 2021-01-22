package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目BUG表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-21 17:03:51
 */
@Data
@TableName("manage_bug")
public class ManageBugEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	private Long bugId;
	/**
	 * BUG名称
	 */
	private String bugName;
	/**
	 * 项目id
	 */
	private Long projectId;
	/**
	 * 严重程度
	 */
	private Integer level;
	/**
	 * 状态0,：激活，1：已解决，2：已关闭
	 */
	private Integer status;
	/**
	 * 创建人id
	 */
	private Long createUserId;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 指派给
	 */
	private Long assigneeId;
	/**
	 * 解决方案0：已解决，1：无法重现，2：待发测试，3：已发测试，4：设计问题，5：重复bug，6：延期处理，7：外部原因，8：不予解决
	 */
	private Integer resolveMethod;
	/**
	 * BUG类型0：代码错误，1：安全问题，2：性能问题，3：设计问题，4：其他
	 */
	private Integer bugType;
	/**
	 * 开始日期
	 */
	private Date beginDate;
	/**
	 * 结束日期
	 */
	private Date endDate;
	/**
	 * 优先级
	 */
	private Integer priority;
	/**
	 * 相关任务
	 */
	private Long relatedTaskId;
	/**
	 * 重现步骤
	 */
	private String reproSteps;

}
