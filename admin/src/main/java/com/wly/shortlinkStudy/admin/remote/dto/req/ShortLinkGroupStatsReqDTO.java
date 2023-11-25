package com.wly.shortlinkStudy.admin.remote.dto.req;

import lombok.Data;

/**
 * 分组短连接监控请求参数
 */
@Data
public class ShortLinkGroupStatsReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
