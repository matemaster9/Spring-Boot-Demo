package tech.matemaster9.batch.mapper;

import org.apache.ibatis.annotations.Mapper;
import tech.matemaster9.batch.dto.PersonDTO;

import java.util.List;

/**
 * @author matemaster9
 * @date 2021/12/20 23:05
 */

@Mapper
public interface PersonMapper {

    public List<PersonDTO> batchQuery();
}
