package com.example.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: Authentication_And_Authorization_Module
 * @package: com.example.backend.entity
 * @className: ResponseResult
 * @author: Rainbow
 * @description: TODO
 * @date: 2024/3/17 16:22
 * @version: 1.0
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}