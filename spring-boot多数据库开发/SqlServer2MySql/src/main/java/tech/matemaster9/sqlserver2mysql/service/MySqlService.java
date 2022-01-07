package tech.matemaster9.sqlserver2mysql.service;

import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/28 21:05
 */
public interface MySqlService {

    boolean batchInsertData2SysUser(List<SysUserDto> data);

    boolean batchUpdateData2SysUser(List<SysUserDto> data);

    // TODO: 增加多线程处理，提高插入和更新效率
    void concurrentInsert2SysUser(List<SysUserDto> data) throws Exception;

    void concurrentUpdateSysUser(List<SysUserDto> data) throws Exception;

}
