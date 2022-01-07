package tech.matemaster9.sqlserver2mysql.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.matemaster9.sqlserver2mysql.entity.enums.Table;

import java.util.Objects;

/**
 * @Description: tb_temp映射实体类
 * @Author: matemaster9
 * @Date: 2021/12/25 11:19
 */
@Data
@AllArgsConstructor
@Builder
public class TempTbDto {
    private String tableName;
    private Long latestCount;
    private Long latestStamp;

    public TempTbDto() {
        tableName = Table.BLANK.getType();
        latestCount = 0L;
        latestStamp = 0L;
    }
}
