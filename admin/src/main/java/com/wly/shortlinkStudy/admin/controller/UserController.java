package com.wly.shortlinkStudy.admin.controller;


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
    public String getUserByUserName(@PathVariable("username") String username) {
        return "Hi " + username;
    }
}
