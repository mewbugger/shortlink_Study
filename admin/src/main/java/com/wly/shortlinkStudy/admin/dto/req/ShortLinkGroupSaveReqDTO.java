package com.wly.shortlinkStudy.admin.dto.req;

import lombok.Data;

/**
 * 新建短连接分组请求参数
 */
@Data
public class ShortLinkGroupSaveReqDTO {

    /**
     * 短链接分组名
     */
    private String groupName;
}
