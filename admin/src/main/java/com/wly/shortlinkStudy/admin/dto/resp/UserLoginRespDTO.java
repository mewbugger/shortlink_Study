package com.wly.shortlinkStudy.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 用户登录接口返回响应
 */
public class UserLoginRespDTO {

    /**
     * 用户token
     */
    private String token;
}
