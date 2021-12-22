package tech.matemaster9.multi.dao.sqlserver;

import org.apache.ibatis.annotations.Param;
import tech.matemaster9.multi.dto.ActAuditBacklogDTO;

import java.util.List;

/**
 * @author matemaster9
 * @date 2021/12/22 9:44
 */
public interface SqlServerMapper {
    int batchInsert(@Param("items") List<ActAuditBacklogDTO> dtoList);

    List<ActAuditBacklogDTO> readAll();
}
