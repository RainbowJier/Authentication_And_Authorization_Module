package com.example.backend.service;

import com.example.backend.entity.ResponseResult;
import com.example.backend.entity.User;

public interface RegisterService {
    ResponseResult register(User user);
}
