package tech.matemaster9.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.matemaster9.service.SysService;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/5 19:23
 */
@RestController
@AllArgsConstructor
public class SysController {

    private SysService serv;

    @RequestMapping("/demo")
    public void demo() {
        System.out.println(serv.getSysUserInfo());
        System.out.println(serv.getCompanyInfo());
    }
}
