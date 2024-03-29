package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.ResponseResult;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import com.example.backend.service.RegisterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.service.impl
 * @className: RegisterServiceImpl
 * @author: Rainbow
 * @description: TODO
 * @date: 2024/3/18 15:48
 * @version: 1.0
 */

@Service
public class RegisterServiceImpl implements RegisterService {
    private static final Logger logger = LogManager.getLogger(RegisterServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Transactional(rollbackFor = Exception.class) // 添加事务管理，遇到Exception时自动回滚
    @Override
    public ResponseResult register(User user) {
        try {
            // Check if username or password is null.
            if (user.getUserName() == null || user.getPassword() == null) {
                throw new IllegalArgumentException("username or password is null");
            }

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUserName, user.getUserName());
            User userExist = userMapper.selectOne(queryWrapper);

            // Check if username already exists.
            if (userExist != null) {
                throw new IllegalStateException("username already exists");
            } else {
                // Encrypt password.
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encryptedPassword);

                // Insert user into database.
                int insert = userMapper.insert(user);

                if (insert <= 0) {
                    throw new RuntimeException("Failed to insert user into database");
                }

                return new ResponseResult(200, "Registration successful");
            }
        } catch (Exception e) {
            logger.error("An error occurred during user registration: {}", e.getMessage());
            return new ResponseResult(500, "An internal server error occurred while processing your request.");
        }
    }
}



