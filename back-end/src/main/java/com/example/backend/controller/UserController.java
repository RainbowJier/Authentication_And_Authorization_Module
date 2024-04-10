package com.example.backend.controller;

import com.example.backend.domain.ResponseResult;
import com.example.backend.domain.dto.UserDto;
import com.example.backend.domain.user.User;
import com.example.backend.service.LoginService;
import com.example.backend.service.LogoutService;
import com.example.backend.service.RegisterService;
import com.example.backend.uitil.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/4/10 22:38
 */

@Api(tags = "User API")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private LogoutService logoutService;

    @Autowired
    private RegisterService registerService;

    /**
     * User Logins in.
     */
    @ApiOperation(value = "User Logins in.", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "username"),
            @ApiImplicitParam(name = "password", value = "password")
    })
    @PostMapping("login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        User user = BeanCopyUtils.copyBean(userDto, User.class);
        return loginService.login(user);
    }


    /**
     * User Logouts.
     *
     * @return
     */
    @ApiOperation(value = "User Logouts.", httpMethod = "GET")
    @GetMapping("logout")
    public ResponseResult logout() {
        return logoutService.logout();
    }


    /**
     * Sign up
     *
     * @param userDto
     * @return
     */
    @ApiOperation("User Registers.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "username"),
//            @ApiImplicitParam(name = "email", value = "email"),
            @ApiImplicitParam(name = "nickName", value = "nickname"),
            @ApiImplicitParam(name = "password", value = "password")
    })
    @PostMapping("register")
    public ResponseResult register(@RequestBody UserDto userDto) {
        User user = BeanCopyUtils.copyBean(userDto, User.class);
        return registerService.register(user);
    }


}
