package com.wly.shortlinkStudy.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkRecycleBinPageDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * url 回收站接口层
 */
public interface RecycleBinService {

    /**
     * 短链接回收站分页查询
     * @param requestParam
     * @return
     */
    Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageDTO requestParam);
}
