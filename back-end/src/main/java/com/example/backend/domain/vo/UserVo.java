package com.example.backend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description：TODO
 * @Author： RainbowJier
 * @Data： 2024/5/22 21:58
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    /**
     * Username
     */
    private String userName;
    /**
     * Nickname
     */
    private String nickName;
    /**
     * Account Status (0 Active 1 Inactive)
     */
    private String status;
    /**
     * Email
     */
    private String email;
    /**
     * Phone Number
     */
    private String phoneNumber;
    /**
     * User Gender (0 Male, 1 Female, 2 Unknown)
     */
    private String sex;
    /**
     * Avatar
     */
    private String avatar;
    /**
     * User Type (0 Administrator, 1 Regular User)
     */
    private String userType;
    /**
     * Creator User ID
     */
    private Long createBy;
    /**
     * Creation Time
     */
    private Date createTime;
    /**
     * Updater
     */
    private Long updateBy;
    /**
     * Last Modified Time
     */
    private Date updateTime;
}
