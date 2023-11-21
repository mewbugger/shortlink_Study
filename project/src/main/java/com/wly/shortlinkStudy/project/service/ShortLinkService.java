package com.wly.shortlinkStudy.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.project.dao.entity.ShortLinkDO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkCreateReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkCreateRespDTO;

/**
 * 短连接接口层
 */


public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * 创建短连接
     * @param requestParam 创建短连接请求参数
     * @return 创建短连接返回实体类
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);
}
