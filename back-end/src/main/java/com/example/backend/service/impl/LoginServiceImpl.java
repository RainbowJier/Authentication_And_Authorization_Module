package com.example.backend.service.impl;

import com.example.backend.entity.LoginUser;
import com.example.backend.entity.ResponseResult;
import com.example.backend.entity.User;
import com.example.backend.service.LoginService;
import com.example.backend.uitil.JwtUtil;
import com.example.backend.uitil.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.service.impl
 * @className: LoginServiceImpl
 * @author: Rainbow
 * @description: TODO
 * @date: 2024/3/18 15:11
 * @version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisCache redisCache;


    /**
     * 用户登录功能。
     *
     * @param user 包含用户名和密码的用户对象。
     * @return 返回一个包含token的响应结果，如果登录成功；否则返回错误信息。
     */
    @Override
    public ResponseResult login(User user) {
        // 创建认证令牌
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

        // 进行用户认证
        Authentication authenticate =
                authenticationManager.authenticate(authenticationToken);

        // 认证失败处理
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 获取登录用户信息，并生成JWT
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();  //使用userid生成token
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        // 将用户认证信息存入Redis缓存
        redisCache.setCacheObject("login:" + userId, loginUser);  //authenticate存入redis

        // 准备响应数据，包含token
        HashMap<String, String> map = new HashMap<>();      //把token响应给前端
        map.put("token", jwt);

        // 返回登录成功响应
        return new ResponseResult(200, "登陆成功", map);
    }

}

