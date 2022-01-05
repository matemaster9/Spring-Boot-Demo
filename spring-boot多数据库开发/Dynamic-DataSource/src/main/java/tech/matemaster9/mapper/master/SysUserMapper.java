package tech.matemaster9.mapper.master;

import org.apache.ibatis.annotations.Select;
import tech.matemaster9.entity.dto.SysUserDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/5 18:51
 */
public interface SysUserMapper {

    @Select("select name, phone, company, sex, address, create_time " +
            "from sys_user"
    )
    List<SysUserDto> selectAll();
}
