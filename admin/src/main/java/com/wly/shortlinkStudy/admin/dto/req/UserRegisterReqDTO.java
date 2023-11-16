package com.wly.shortlinkStudy.admin.dto.req;

import lombok.Data;

/**
 * 用户注册入参
 */
@Data
public class UserRegisterReqDTO {
    /**
     * 用户姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 手机号
     */
    private String phone;
}
