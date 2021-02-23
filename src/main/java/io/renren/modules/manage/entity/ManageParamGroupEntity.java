package io.renren.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 参数组表
 */
@Data
@TableName("manage_param_group")
public class ManageParamGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer uuid;
    /**
     * 自增主键
     */
    @TableId
    @NotNull(message = "参数组id不能为空", groups = {UpdateGroup.class})
    private Long groupId;
    /**
     * 组名
     */
    @NotBlank(message = "组名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String groupName;

    @TableField(exist = false)
    private List<ManageParamEntity> children;
}
