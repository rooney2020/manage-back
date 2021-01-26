package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "主键不能为空！", groups = {UpdateGroup.class})
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
	@NotNull(message = "打卡类型不能为空！", groups = {AddGroup.class, UpdateGroup.class})
	private Integer punchType;
	/**
	 * 位置
	 */
	@NotBlank(message = "位置不能为空！", groups = {AddGroup.class, UpdateGroup.class})
	private String position;

}
