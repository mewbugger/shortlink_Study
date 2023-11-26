package com.wly.shortlinkStudy.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.remote.dto.ShortLinkRemoteService;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkGroupStatsReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkStatsReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkGroupStatsAccessRecordRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkGroupStatsRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkStatsRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortLinkStatsController {

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/admin/v1/stats")
    public Result<ShortLinkStatsRespDTO> oneShortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return shortLinkRemoteService.oneShortLinkStats(requestParam);
    }

    /**
     * 访问分组短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/admin/v1/stats/group")
    public Result<ShortLinkGroupStatsRespDTO> groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
        return shortLinkRemoteService.groupShortLinkStats(requestParam);
    }


    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return shortLinkRemoteService.shortLinkStatsAccessRecord(requestParam);
    }

    @GetMapping("/api/short-link/admin/v1/stats/access-record/group")
    public Result<IPage<ShortLinkGroupStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam) {
        return shortLinkRemoteService.groupShortLinkStatsAccessRecord(requestParam);
    }
}
