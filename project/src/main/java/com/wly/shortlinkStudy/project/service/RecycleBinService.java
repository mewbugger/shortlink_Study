package com.wly.shortlinkStudy.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.project.dao.entity.ShortLinkDO;
import com.wly.shortlinkStudy.project.dto.req.RecycleBinRecoverReqDTO;
import com.wly.shortlinkStudy.project.dto.req.RecycleBinRemoveReqDTO;
import com.wly.shortlinkStudy.project.dto.req.RecycleBinSaveReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkRecycleBinPageDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkPageRespDTO;

/**
 * 回收站管理接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * 保存回收站
     * @param requestParam 保存回收站请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * 回收站分页查询短链接
     * @param requestParam 分页查询短链接请求参数
     * @return 分页查询短链接返回参数
     */
    IPage<ShortLinkPageRespDTO> pageRecycleBinShortLink(ShortLinkRecycleBinPageDTO requestParam);

    /**
     * 回收站恢复短链接
     * @param requestParam 回收站恢复短链接请求参数
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);

    /**
     * 回收站移除短链接
     * @param requestParam 回收站移除短链接请求参数
     */
    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}
