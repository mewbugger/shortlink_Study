package com.wly.shortlinkStudy.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkStatsReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkGroupStatsRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkStatsRespDTO;


public interface ShortLinkStatsService  {

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);


    /**
     * 访问单个短链接指定时间内访问记录监控数据
     * @param requestParam
     * @return
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);

    /**
     * 访问分组短链接指定时间内监控数据
     * @param requestParam
     * @return
     */
    ShortLinkGroupStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);
}
