package com.wly.shortlinkStudy.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wly.shortlinkStudy.admin.common.database.BaseDO;
import lombok.Data;

@TableName("t_user")
@Data
public class UserDO extends BaseDO {

    /**
     * 用户id
     */
    private Integer id;

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

    /**
     * 删除时间戳
     */
    private Long deletionTime;


}
