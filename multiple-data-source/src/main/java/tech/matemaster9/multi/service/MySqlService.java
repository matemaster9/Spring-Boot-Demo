package tech.matemaster9.multi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.matemaster9.multi.dao.mysql.MySqlMapper;
import tech.matemaster9.multi.dto.ActAuditBacklogDTO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author matemaster9
 * @date 2021/12/22 10:37
 */
@Service
public class MySqlService {

    @Resource
    private MySqlMapper mySqlMapper;

    public void batchInsert(List<ActAuditBacklogDTO> dtoList) {
        if (Objects.isNull(dtoList) || dtoList.size() == 0) {
            return;
        }

        dtoList.forEach((a) -> {
            mySqlMapper.insert(a);
        });
    }
}
