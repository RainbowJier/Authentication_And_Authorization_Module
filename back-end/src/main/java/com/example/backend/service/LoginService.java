package com.example.backend.service;

import com.example.backend.entity.ResponseResult;
import com.example.backend.entity.User;

public interface LoginService {
    ResponseResult login(User user);
}
