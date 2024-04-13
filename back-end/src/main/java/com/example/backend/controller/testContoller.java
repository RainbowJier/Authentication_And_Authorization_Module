package com.example.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/4/13 23:31
 */

@RestController
@RequestMapping("test")
public class testContoller {

    @RequestMapping("hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello() {
        return "hello";
    }

}
