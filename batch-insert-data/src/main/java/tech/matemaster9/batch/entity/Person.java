package tech.matemaster9.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author matemaster9
 * @date 2021/12/20 14:35
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Long id;
    private String name;
    private Long phone;
    private BigDecimal salary;
    private String company;
    private Integer single;
    private Integer sex;
    private String address;
    private LocalDateTime createTime;
    private String createUser;
}
