package tech.matemaster9.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.matemaster9.multi.service.MySqlService;
import tech.matemaster9.multi.service.SqlServerService;

/**
 * @author matemaster9
 * @date 2021/12/22 11:06
 */
@RestController
public class MigrateDataController {
    @Autowired
    private MySqlService mysqlService;
    @Autowired
    private SqlServerService sqlServerService;

    @RequestMapping("/migrate-data")
    public void migrateData() {
        mysqlService.batchInsert(sqlServerService.getData());
    }
}
