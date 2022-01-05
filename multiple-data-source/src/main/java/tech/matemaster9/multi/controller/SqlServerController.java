package tech.matemaster9.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.matemaster9.multi.service.SqlServerService;

/**
 * @author matemaster9
 * @date 2021/12/22 9:50
 */
@RestController
public class SqlServerController {

    @Autowired
    private SqlServerService sqlServerService;

    @RequestMapping("/sqlserver-demo")
    public void sqlserverDemo() {
        System.out.println("数据量：" + sqlServerService.getData().size());
    }
    
    @RequestMapping("/batch-insert-demo")
    public void batchInsertDemo() {
        // 生成随机数据接口
        sqlServerService.batchInsertDemo();
    }
}
