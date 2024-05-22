package com.example.backend.service.impl;

import com.example.backend.domain.entity.LoginUser;
import com.example.backend.domain.entity.ResponseResult;
import com.example.backend.service.LogoutService;
import com.example.backend.uitil.RedisCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/4/6 12:17
 */
@Service
public class LogoutServiceImpl implements LogoutService {
    private static final Logger logger = LogManager.getLogger(LogoutServiceImpl.class);

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult logout() {
        try {
            // Get user from SecurityContextHolder
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();

            // Get user id.
            Long userid = loginUser.getUser().getId();
            
            // Delete user from Redis.
            redisCache.deleteObject("login:" + userid);

            return new ResponseResult<>(200, "Logout Successfully.");
        } catch (Exception e) {
            logger.error("An error occurred during user registration: {}", e.getMessage());
            return new ResponseResult<>(500, "An internal server error occurred while processing your request.");
        }
    }
}

