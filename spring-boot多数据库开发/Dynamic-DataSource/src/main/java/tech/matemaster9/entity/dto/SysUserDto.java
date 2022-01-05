package tech.matemaster9.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/4 21:49
 */
@Data
@AllArgsConstructor
public class SysUserDto {
    private String name;
    private String phone;
    private String company;
    private Integer sex;
    private String address;
    private LocalDateTime createTime;
}
