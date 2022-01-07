package tech.matemaster9.sqlserver2mysql.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tech.matemaster9.sqlserver2mysql.facade.MigrateDataFacade;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/1 15:29
 */
@RestController
@AllArgsConstructor
public class MigrateDataController {

    private MigrateDataFacade migrateDataFacade;
}
