package tech.matemaster9.sqlserver2mysql.mapper.sqlserver;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/25 10:58
 */
@Component
public interface SqlServerMapper {

    /**
     * 用于原始插入操作
     * @param data
     * @return
     */
    @Insert("<script>" +
            "insert into SYS_USER " +
            "(name, phone, company, sex, address, create_time, latest_stamp) " +
            "values " +
            "<foreach collection = 'list' item = 'a' separator = ','> " +
            "(#{a.name},#{a.phone},#{a.company},#{a.sex},#{a.address},GetDate(),default) " +
            "</foreach> " +
            "</script>"
    )
    Integer insertTestData(@Param("list") List<SysUserDto> data);

    /**
     * 一次读取 SYS_USER 表中的全部数据
     * @return
     */
    @Select("select name, phone, company, sex, address, create_time, latest_stamp " +
            "from SYS_USER"
    )
    List<SysUserDto> readAllData();

    @Select("select max(id) " +
            "from SYS_USER"
    )
    Long readLatestCount();

    /**
     * 读取SQL server数据库中的最新时间戳记录
     * @return
     */
    @Select("select cast(max(latest_stamp) as bigint) " +
            "from SYS_USER"
    )
    Long readLatestStamp();

    /**
     * 依据MySQL提供的时间戳和id来读取SQL server中的变动数据
     * @param latestStamp
     * @param latestCount
     * @return
     */
    @Select("select name, phone, company, sex, address, create_time, latest_stamp " +
            "from SYS_USER " +
            "where id <= count and cast(latest_stamp as bigint) > stamp"
    )
    List<SysUserDto> readChangedData(@Param("stamp") Long latestStamp, @Param("count") Long latestCount);

    /**
     * 依据MySQL提供的id来读取SQL server中的新增数据
     * @return
     */
    @Select("select name, phone, company, sex, address, create_time, latest_stamp " +
            "from SYS_USER " +
            "where id > #{count}"
    )
    List<SysUserDto> readAddData(@Param("count") Long latestCount);
}
