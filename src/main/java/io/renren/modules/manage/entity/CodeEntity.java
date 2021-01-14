package io.renren.modules.manage.entity;

import lombok.Data;

/**
 * 请修改注释
 *
 * @author zhaoliyuan
 * @date 2021.01.14
 */
@Data
public class CodeEntity {
    private Integer code;
    private String name;
    private CodeEntity[] children;
}
