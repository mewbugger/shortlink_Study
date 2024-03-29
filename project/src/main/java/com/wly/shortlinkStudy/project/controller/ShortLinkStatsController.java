package com.wly.shortlinkStudy.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.project.common.convention.result.Result;
import com.wly.shortlinkStudy.project.common.convention.result.Results;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkStatsReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkGroupStatsAccessRecordRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkGroupStatsRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkStatsRespDTO;
import com.wly.shortlinkStudy.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接监控控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短连接指定时间内的监控数据
     * @param requestParam
     * @return
     */
    @GetMapping("api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

    /**
     * 访问分组短链接指定时间内监控数据
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/v1/stats/group")
    public Result<ShortLinkGroupStatsRespDTO> groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.groupShortLinkStats(requestParam));
    }

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam
     * @return
     */
    @GetMapping("api/short-link/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }


    /**
     * 访问分组短链接指定时间内访问记录监控数据
     * @param requestParam
     * @return
     */
    @GetMapping("api/short-link/v1/stats/access-record/group")
    public Result<IPage<ShortLinkGroupStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.groupShortLinkStatsAccessRecord(requestParam));
    }
}
