package tech.matemaster9.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.matemaster9.batch.service.Serv;

/**
 * @author matemaster9
 * @date 2021/12/20 23:30
 */
@RestController
public class DemoController {

    @Autowired
    private Serv service;

    @GetMapping("/demo")
    public int count(){
        int size = service.batchQuery().size();
        System.out.println(size);
        return size;
    }
}
