package com.wly.shortlinkStudy.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.project.common.convention.result.Result;
import com.wly.shortlinkStudy.project.common.convention.result.Results;
import com.wly.shortlinkStudy.project.dto.req.RecycleBinRecoverReqDTO;
import com.wly.shortlinkStudy.project.dto.req.RecycleBinRemoveReqDTO;
import com.wly.shortlinkStudy.project.dto.req.RecycleBinSaveReqDTO;
import com.wly.shortlinkStudy.project.dto.req.ShortLinkRecycleBinPageDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkPageRespDTO;
import com.wly.shortlinkStudy.project.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;

    /**
     * 短链接移至回收站
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam) {
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接参数
     * @return
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageDTO requestParam) {
        return Results.success(recycleBinService.pageRecycleBinShortLink(requestParam));
    }

    /**
     * 回收站恢复短链接
     * @param requestParam 回收站恢复短链接请求参数
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        recycleBinService.recoverRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 回收站移除短链接功能
     */
    @PostMapping("/api/short-link/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        recycleBinService.removeRecycleBin(requestParam);
        return Results.success();
    }

}
