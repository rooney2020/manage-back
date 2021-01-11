package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 打卡签到表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-01-11 14:49:54
 */
@Data
@TableName("manage_punch")
public class ManagePunchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long punchId;
	/**
	 * 签到人id
	 */
	private Long userId;
	/**
	 * 打卡时间
	 */
	private Date createTime;
	/**
	 * 0：正常上班打卡，1：正常下班打卡，2：外勤上班打卡，3：外勤下班打卡
	 */
	private Integer punchType;
	/**
	 * 位置
	 */
	private String position;

}
