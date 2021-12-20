package tech.matemaster9.batch.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.matemaster9.batch.entity.Person;

import java.util.List;

/**
 * @author matemaster9
 * @date 2021/12/20 14:38
 */
@Mapper
public interface PersonMapper {
    int batchInsert(@Param("items") List<Person> people);
}
