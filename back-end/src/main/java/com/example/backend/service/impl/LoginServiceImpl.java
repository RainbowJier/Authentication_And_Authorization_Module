package com.example.backend.service.impl;

import com.example.backend.domain.ResponseResult;
import com.example.backend.domain.user.LoginUser;
import com.example.backend.domain.user.User;
import com.example.backend.service.LoginService;
import com.example.backend.uitil.JwtUtil;
import com.example.backend.uitil.RedisCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);

    /**
     * Login
     *
     * @param user 包含用户名和密码的用户对象。
     * @return 返回一个包含token的响应结果，如果登录成功；否则返回错误信息。
     */
    @Override
    public ResponseResult login(User user) {
        // Create an authentication token with the user's credentials.

        // Get the authenticationToken from   UserDetailServiceImpl   .******************

        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());

        try {
            // User authentication.
            Authentication authenticate =
                    authenticationManager.authenticate(authenticationToken);

            // Authentication failure handling.
            if (Objects.isNull(authenticate)) {
                throw new RuntimeException("username or password is incorrect.");
            }

            // Generate a JWT using the user's ID.
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            String userId = loginUser.getUser().getId().toString();
            String jwt = JwtUtil.createJWT(userId);

            // Store the authentication information in Redis.
            redisCache.setCacheObject("login:" + userId, loginUser);

            // Return the JWT to the client.
            HashMap<String, String> map = new HashMap<>();
            map.put("token", jwt);
            // Return a response result containing the JWT and other information.
            return new ResponseResult<>(200, "登陆成功", map);

        } catch (Exception e) {
            logger.error("An error occurred during user registration: {}", e.getMessage());
            return new ResponseResult<>(500, "An internal server error occurred while processing your request.");
        }
    }
}

