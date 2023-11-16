package com.wly.shortlinkStudy.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.admin.dao.entity.UserDO;
import com.wly.shortlinkStudy.admin.dto.req.UserLoginReqDTO;
import com.wly.shortlinkStudy.admin.dto.req.UserRegisterReqDTO;
import com.wly.shortlinkStudy.admin.dto.req.UserUpdateReqDTO;
import com.wly.shortlinkStudy.admin.dto.resp.UserLoginRespDTO;
import com.wly.shortlinkStudy.admin.dto.resp.UserRespDTO;

public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 用户名存在返回True 不存在返回False
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     * @param requestParam 注册用户请求参数
     */
    void Register(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户
     * @param requestParam
     */
    void update(UserUpdateReqDTO requestParam);


    /**
     * 用户登录
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回参数
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户是否登录
     * @param token 用户登录token
     * @return
     */
    Boolean checkLogin(String username, String token);

    /**
     * 用户退出登录
     * @param username 用户名
     * @param token 用户退出登录token
     */
    void logout(String username, String token);
}
