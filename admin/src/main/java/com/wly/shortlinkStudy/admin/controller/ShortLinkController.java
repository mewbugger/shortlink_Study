package com.wly.shortlinkStudy.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.remote.dto.ShortLinkRemoteService;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 短链接后管控制层
 */
@RestController
public class ShortLinkController {


    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 新增短链接
     * @param requestParam 新增短链接参数
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }


    /**
     * 修改短链接
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        return shortLinkRemoteService.updateShortLink(requestParam);
    }


    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接参数
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }





}
