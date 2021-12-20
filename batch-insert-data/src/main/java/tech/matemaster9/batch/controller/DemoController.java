package tech.matemaster9.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.matemaster9.batch.service.PersonService;

/**
 * @author matemaster9
 * @date 2021/12/20 15:12
 */

@RestController
public class DemoController {

    @Autowired
    private PersonService serv;

    @RequestMapping("/demo")
    public void batch() {
        serv.batchDemo();
    }
}
