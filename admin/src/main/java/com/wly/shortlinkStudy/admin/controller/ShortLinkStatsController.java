package com.wly.shortlinkStudy.admin.controller;


import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.remote.dto.ShortLinkRemoteService;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkStatsReqDTO;
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
}
