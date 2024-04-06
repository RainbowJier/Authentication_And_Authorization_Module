package com.example.backend.controller.Authentication;

import com.example.backend.domain.ResponseResult;
import com.example.backend.domain.user.User;
import com.example.backend.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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


@RestController
@RequestMapping("user")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("login")

    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }
}
