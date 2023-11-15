package com.wly.shortlinkStudy.admin.dto.resp;

import lombok.Data;

@Data
public class UserActualRespDTO {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String username;


    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

}
