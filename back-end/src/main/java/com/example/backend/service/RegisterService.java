package com.example.backend.service;

import com.example.backend.domain.entity.ResponseResult;
import com.example.backend.domain.entity.User;

public interface RegisterService {
    ResponseResult register(User user);
}
