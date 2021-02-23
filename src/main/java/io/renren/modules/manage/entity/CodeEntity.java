package io.renren.modules.manage.entity;

import lombok.Data;

/**
 * 参数组合实体
 */
@Data
public class CodeEntity {
    private Integer code;
    private String name;
    private CodeEntity[] children;
}
