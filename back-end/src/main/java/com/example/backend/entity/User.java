package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Users Table(User)实体类
 *
 * @author makejava
 * @since 2024-03-17 17:01:20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 705892264344713214L;
    /**
     * Primary Key
     */
    private Long id;
    /**
     * Username
     */
    private String userName;
    /**
     * Nickname
     */
    private String nickName;
    /**
     * Password
     */
    private String password;
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
    /**
     * Deletion Flag (0 Not Deleted, 1 Deleted)
     */
    private Integer delFlag;

}

