package com.wly.shortlinkStudy.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.project.dao.entity.ShortLinkDO;
import com.wly.shortlinkStudy.project.dto.biz.ShortLinkStatsRecordDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkBatchCreateReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkCreateReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkPageReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkUpdateReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkBatchCreateRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkCreateRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkPageRespDTO;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.util.List;

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
     * 修改短链接信息
     * @param requestParam 修改短链接请求参数
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接请求参数
     * @return 分页查询短链接返回参数
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内数量
     * @param requestParam 创建短链接分组内数量请求参数
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);


    /**
     * 短链接跳转
     * @param shortUri 短链接后缀
     * @param request http 请求
     * @param response http 响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * 批量创建短链接
     * @param requestParam 批量创建短链接请求参数
     * @return 批量创建短链接返回参数
     */
    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);


    /**
     * 短链接统计
     *
     * @param fullShortUrl         完整短链接
     * @param gid                  分组标识
     * @param shortLinkStatsRecord 短链接统计实体参数
     */
    void shortLinkStats(String fullShortUrl, String gid, ShortLinkStatsRecordDTO shortLinkStatsRecord);


}
