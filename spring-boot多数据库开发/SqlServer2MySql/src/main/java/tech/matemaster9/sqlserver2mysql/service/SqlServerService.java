package tech.matemaster9.sqlserver2mysql.service;

import org.apache.ibatis.annotations.Param;
import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/28 21:05
 */
public interface SqlServerService {

    List<SysUserDto> readAddData();

    List<SysUserDto> readChangedData();

    void concurrentInsertData();

}
