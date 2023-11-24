package com.wly.shortlinkStudy.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 短链接回收站分页查询请求参数
 */
@Data
public class ShortLinkRecycleBinPageDTO extends Page {

    /**
     * 短链接分组集合
     */
    private List<String> gidList;
}
