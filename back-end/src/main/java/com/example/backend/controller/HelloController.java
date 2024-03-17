package com.example.backend.controller;

import com.example.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
