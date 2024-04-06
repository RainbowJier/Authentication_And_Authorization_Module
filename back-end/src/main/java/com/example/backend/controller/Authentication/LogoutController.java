package com.example.backend.controller.Authentication;

import com.example.backend.domain.ResponseResult;
import com.example.backend.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/4/6 12:02
 */

@RestController
@RequestMapping("user")
public class LogoutController {

    @Autowired
    private LogoutService logoutService;

    @GetMapping("logout")
    public ResponseResult logout() {
        return logoutService.logout();
    }
}
