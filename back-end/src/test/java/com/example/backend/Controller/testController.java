package com.example.backend.Controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/4/13 23:32
 */


@SpringBootTest
public class testController {
    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello() {
        return "hello";
    }

}
