package tech.matemaster9.multi.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author matemaster9
 * @date 2021/12/22 9:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ActAuditBacklogDTO {
    private Long id;
    private String activityId;
    private String deptId;
    private String submitterId;
    private String submitterName;
    private LocalDateTime submitTime;
    private Integer status;
    private Integer deleteFlag;
    private byte[] stamp;
}
