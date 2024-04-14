package com.example.backend.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * User table(SysRole)实体类
 *
 * @author makejava
 * @since 2024-04-14 21:04:29
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role implements Serializable {
    private Long id;

    private String name;
    /**
     * 角色权限字符串
     */
    private String roleKey;
    /**
     * 角色状态（0正常 1停用）
     */
    private String status;
    /**
     * del_flag
     */
    private Integer delFlag;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    /**
     * 备注
     */
    private String remark;
}

