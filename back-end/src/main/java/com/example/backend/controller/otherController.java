package com.example.backend.controller;

import com.example.backend.domain.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/3/22 14:10
 */

@RestController
public class otherController {


    @GetMapping("other")
    public ResponseResult test() {
        return new ResponseResult(200, "testing");
    }
}
