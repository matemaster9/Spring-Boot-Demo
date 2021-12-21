package tech.matemaster9.batch.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author matemaster9
 * @date 2021/12/20 23:03
 */
@Data
public class PersonDTO {
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
