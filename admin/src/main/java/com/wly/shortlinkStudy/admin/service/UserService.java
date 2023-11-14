package com.wly.shortlinkStudy.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.admin.dao.entity.UserDO;
import com.wly.shortlinkStudy.admin.dto.resp.UserRespDTO;

public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserRespDTO getUserByUsername(String username);

}
