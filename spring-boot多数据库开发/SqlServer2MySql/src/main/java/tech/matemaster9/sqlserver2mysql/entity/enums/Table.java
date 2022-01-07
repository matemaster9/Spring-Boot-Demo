package tech.matemaster9.sqlserver2mysql.entity.enums;

import lombok.Getter;

/**
 * @Description: 表名枚举器
 * @Author: matemaster9
 * @Date: 2021/12/25 11:29
 */
@Getter
public enum Table {
    SYS_USER("sys_user"),

    TB_TEMP("tb_temp"),

    BLANK("");

    private final String type;

    Table(String type) {
        this.type = type;
    }
}
