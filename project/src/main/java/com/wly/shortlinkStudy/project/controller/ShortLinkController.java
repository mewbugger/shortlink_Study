package com.wly.shortlinkStudy.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkPageReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkPageRespDTO;
import lombok.RequiredArgsConstructor;
import com.wly.shortlinkStudy.project.common.convention.result.Result;
import com.wly.shortlinkStudy.project.common.convention.result.Results;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkCreateReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkCreateRespDTO;
import com.wly.shortlinkStudy.project.service.ShortLinkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短连接控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    /**
     * 新增短链接
     * @param requestParam 新增短链接参数
     * @return
     */
    @PostMapping("/api/short-link/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        ShortLinkCreateRespDTO result = shortLinkService.createShortLink(requestParam);
        return Results.success(result);
    }

    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接参数
     * @return
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

}
