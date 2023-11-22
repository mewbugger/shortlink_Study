package com.wly.shortlinkStudy.admin.dto.resp;

import lombok.Data;

/**
 * 短连接分组返回实体对象
 */
@Data
public class ShortLinkGroupRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组排序
     */
    private Integer sortOrder;

    /**
     * 同一分组下短链接数量
     */
    private Integer shortLinkCount;
}
