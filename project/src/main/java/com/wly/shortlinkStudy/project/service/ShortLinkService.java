package com.wly.shortlinkStudy.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.project.dao.entity.ShortLinkDO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkCreateReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkPageReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkCreateRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkPageRespDTO;

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

    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接请求参数
     * @return 分页查询短链接返回参数
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);
}
