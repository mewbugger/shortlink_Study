package com.wly.shortlinkStudy.admin.dto.req;

import lombok.Data;

/**
 * 短连接分组排序参数
 */
@Data
public class ShortLinkGroupSortReqDTO {

    /**
     * 分组ID
     */
    private String gid;

    /**
     * 排序
     */
    private Integer sortOrder;

}
