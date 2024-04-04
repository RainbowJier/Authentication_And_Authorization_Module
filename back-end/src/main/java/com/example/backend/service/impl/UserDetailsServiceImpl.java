package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.domain.user.LoginUser;
import com.example.backend.domain.user.User;
import com.example.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.service.impl
 * @className: UserDetailsServiceImpl
 * @author: Rainbow
 * @description: Override the UserDetailsService
 * @date: 2024/3/17 17:04
 * @version: 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    /**
     * Verify username and password with database.
     *
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Query user information based on the username
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, username);

        // Throw the exception if the username or password is incorrect.
        User user = Optional.ofNullable(userMapper.selectOne(wrapper))
                .orElseThrow(() -> new UsernameNotFoundException("The user name or password is incorrect"));

        return new LoginUser(user);
    }
}









