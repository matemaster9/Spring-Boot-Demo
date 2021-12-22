package tech.matemaster9.multi.dao.mysql;

import tech.matemaster9.multi.dto.ActAuditBacklogDTO;

import java.util.List;

/**
 * @author matemaster9
 * @date 2021/12/22 10:34
 */
public interface MySqlMapper {
    int insert(ActAuditBacklogDTO dto);
}
