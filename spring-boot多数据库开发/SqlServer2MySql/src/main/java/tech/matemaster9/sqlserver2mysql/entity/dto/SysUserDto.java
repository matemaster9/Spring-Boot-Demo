package tech.matemaster9.sqlserver2mysql.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description: sys_user映射实体类
 * @Author: matemaster9
 * @Date: 2021/12/25 11:14
 */
@Data
@AllArgsConstructor
@Builder
public class SysUserDto {
    private String name;
    private String phone;
    private String company;
    private Integer sex;
    private String address;
    private LocalDateTime createTime;
}
