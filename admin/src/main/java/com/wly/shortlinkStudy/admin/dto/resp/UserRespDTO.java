package com.wly.shortlinkStudy.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wly.shortlinkStudy.admin.common.serialize.PhoneDesensitizationSerializer;
import lombok.Data;

/**
 * 用户返回参数响应
 */
@Data
public class UserRespDTO {

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
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;



}
