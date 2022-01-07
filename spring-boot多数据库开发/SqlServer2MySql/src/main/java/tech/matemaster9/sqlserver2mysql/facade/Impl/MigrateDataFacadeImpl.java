package tech.matemaster9.sqlserver2mysql.facade.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tech.matemaster9.sqlserver2mysql.entity.dto.SysUserDto;
import tech.matemaster9.sqlserver2mysql.facade.MigrateDataFacade;
import tech.matemaster9.sqlserver2mysql.service.MySqlService;
import tech.matemaster9.sqlserver2mysql.service.SqlServerService;

import java.util.List;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2021/12/29 21:47
 */
@Component("MigrateDataFacade")
@AllArgsConstructor
public class MigrateDataFacadeImpl implements MigrateDataFacade {

    private static final int SHARDING_COUNT = 5000;

    private MySqlService mysqlServ;
    private SqlServerService sqlserverServ;

    @Override
    public void migrateData() {

    }
}
