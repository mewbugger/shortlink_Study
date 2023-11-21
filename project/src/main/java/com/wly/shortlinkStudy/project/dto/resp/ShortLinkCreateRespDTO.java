package com.wly.shortlinkStudy.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短连接创建响应对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRespDTO {

    /**
     * 分组标识
     */
    private String gid;


    /**
     * 原始链接
     */
    private String originUrl;


    /**
     * 短连接
     */
    private String fullShortUrl;
}
