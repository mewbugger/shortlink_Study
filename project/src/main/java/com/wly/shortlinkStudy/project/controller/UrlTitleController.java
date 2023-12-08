package com.wly.shortlinkStudy.project.controller;

import com.wly.shortlinkStudy.project.common.convention.result.Result;
import com.wly.shortlinkStudy.project.common.convention.result.Results;
import com.wly.shortlinkStudy.project.service.impl.UrlTitleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * URl标题控制层
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    private final UrlTitleServiceImpl urlTitleServiceImpl;

    /**
     * 根据url获取对于网站的标题
     * @param url
     * @return
     */
    @GetMapping("/api/short-link/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return Results.success(urlTitleServiceImpl.getTitleByUrl(url));
    }
}
