package com.wly.shortlinkStudy.admin.dto.req;

import lombok.Data;

/**
 * 短连接分组修改参数
 */
@Data
public class ShortLinkGroupUpdateReqDTO {


    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名
     */
    private String name;
}
