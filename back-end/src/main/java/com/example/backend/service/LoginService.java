package com.example.backend.service;

import com.example.backend.domain.ResponseResult;
import com.example.backend.domain.user.User;

public interface LoginService {
    ResponseResult login(User user);
}
