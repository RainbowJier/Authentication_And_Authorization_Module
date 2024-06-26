package com.example.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description：TODO
 * @Author： 30218
 * @Data： 2024/4/10 21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    /**
     * Username
     */
    private String userName;
    /**
     * Password
     */
    private String password;

    private String email;

}
