package com.example.backend.controller;


import com.example.backend.entity.ResponseResult;
import com.example.backend.entity.User;
import com.example.backend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;


    @PostMapping("register")
    public ResponseResult register(@RequestBody User user) {
        return registerService.register(user);
    }

}
