package com.example.backend.controller;

import com.example.backend.entity.ResponseResult;
import com.example.backend.entity.User;
import com.example.backend.service.LoginService;
import com.example.backend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.controller
 * @className: LoginController
 * @author: Rainbow
 * @description: TODO
 * @date: 2024/3/18 15:09
 * @version: 1.0
 */


@RestController("user")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("login")

    public ResponseResult login(@RequestBody User user) {

        System.out.println(user);
        return loginService.login(user);
    }


}
