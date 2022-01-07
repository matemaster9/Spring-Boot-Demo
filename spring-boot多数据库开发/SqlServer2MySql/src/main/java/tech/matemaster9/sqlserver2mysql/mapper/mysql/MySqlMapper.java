package tech.matemaster9.sqlserver2mysql.mapper.mysql;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;
import tech.matemaster9.sqlserver2mysql.entity.dto.TempTbDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/25 10:58
 */
@Component
public interface MySqlMapper {

    /*****************************针对 sys_user 的操作*****************************************/
    /***
     * 向 sys_user 表中插入单条数据指令
     * @param dto
     * @return
     */
    @Insert("<script>" +
            "insert into sys_user(name, phone, company, sex, address, create_time, latest_stamp) " +
            "values " +
            "(#{a.name}, #{a.phone}, #{a.company}, #{a.sex}, #{a.address}, #{a.createTime}, current_timestamp)" +
            "</script>"
    )
    Integer insertSingleData2SysUser(@Param("a") SysUserDto dto);

    /**
     * 向 sys_user 一次插入多条数据指令
     *
     * @param data
     * @return
     */
    @Insert("<script>" +
            "insert into sys_user(name, phone, company, sex, address, create_time, latest_stamp) " +
            "values " +
            "<foreach collection = 'list' item = 'a' separator =','>" +
            "(#{a.name}, #{a.phone}, #{a.company}, #{a.sex}, #{a.address},# {a.createTime},current_timestamp) " +
            "</foreach>" +
            "</script>"
    )
    Integer insertMassData2SysUser(@Param("list") List<SysUserDto> data);

    /**
     * 针对 SYS_USER 表中变动的数据，对MySQL数据库的 sys_user 表进行更新
     *
     * @param dto
     * @param phone
     * @return
     */
    @Update("update sys_user " +
            "set name = #{a.name}, company = #{a.company}, sex = #{a.sex}, " +
            "address = #{a.address}, create_time = #{a.createTime}, latest_stamp = current_timestamp " +
            "where phone = #{phone}"
    )
    Integer updateData2SysUser(@Param("a") SysUserDto dto, @Param("phone") String phone);

    /*****************************针对 tb_temp 的操作*****************************************/
    /**
     * 将当前最新的数据量和时间戳插入临时表
     *
     * @param dto
     * @return
     */
    @Insert("<script>" +
            "insert into tb_temp(tb_name, latest_count, latest_stamp)" +
            "values" +
            "(#{a.tableName}, #{a.latestCount}, #{a.latestStamp})" +
            "</script>"
    )
    Integer insertData2TempTb(@Param("a") TempTbDto dto);

    /**
     * 依据表名查询关于此表对应的最新数据
     *
     * @param tableName
     * @return
     */
    @Results(id = "TempTbMap", value = {
            @Result(property = "tableName", column = "tb_name"),
            @Result(property = "latestCount", column = "latest_count"),
            @Result(property = "latestStamp", column = "latest_stamp")
    })
    @Select("select tb_name, latest_count, latest_stamp " +
            "from tb_temp " +
            "where id = (select max(id) from tb_temp where tb_name = #{tbName})"
    )
    TempTbDto queryDataFromTempTb(@Param("tbName") String tableName);
}
