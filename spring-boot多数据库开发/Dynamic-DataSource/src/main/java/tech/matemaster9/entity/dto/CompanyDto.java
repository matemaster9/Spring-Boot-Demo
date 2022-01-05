package tech.matemaster9.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/5 18:53
 */
@Data
@AllArgsConstructor
public class CompanyDto {
    private String name;
    private LocalDateTime createTime;
}
