package tech.matemaster9.mapper.slave;

import org.apache.ibatis.annotations.Select;
import tech.matemaster9.entity.dto.CompanyDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/5 18:51
 */
public interface CompanyMapper {

    @Select("select name, create_time " +
            "from COMPANY"
    )
    List<CompanyDto> selectAll();
}
