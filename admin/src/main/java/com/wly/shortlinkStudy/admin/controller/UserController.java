package com.wly.shortlinkStudy.admin.controller;


import cn.hutool.core.bean.BeanUtil;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.common.convention.result.Results;
import com.wly.shortlinkStudy.admin.common.enums.UserErrorCodeEnum;
import com.wly.shortlinkStudy.admin.dto.resp.UserActualRespDTO;
import com.wly.shortlinkStudy.admin.dto.resp.UserRespDTO;
import com.wly.shortlinkStudy.admin.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户管理控制层
 */
@RestController
@RequiredArgsConstructor // 使用构造器注入bean代替autowired
public class UserController {

    private final UserService userService;


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username) {
        UserRespDTO userRespDTO = userService.getUserByUsername(username);
        if (userRespDTO == null) {
            return new Result<UserRespDTO>().setCode(UserErrorCodeEnum.USER_NULL.code()).setMessage(UserErrorCodeEnum.USER_NULL.message());
        } else {
            return Results.success(userRespDTO);
        }
    }

    @GetMapping("/api/shortlink/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUserName(@PathVariable("username") String username) {
        UserRespDTO userRespDTO = userService.getUserByUsername(username);
        if (userRespDTO == null) {
            return new Result<UserActualRespDTO>().setCode(UserErrorCodeEnum.USER_NULL.code()).setMessage(UserErrorCodeEnum.USER_NULL.message());
        } else {
            return Results.success(BeanUtil.toBean(userRespDTO, UserActualRespDTO.class));

        }
    }
}
