package com.example.backend.service;

import com.example.backend.domain.entity.ResponseResult;
import com.example.backend.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);
}
