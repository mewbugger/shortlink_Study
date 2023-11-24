package com.wly.shortlinkStudy.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wly.shortlinkStudy.project.dao.entity.ShortLinkDO;
import lombok.Data;

import java.util.List;

/**
 * 短链接回收站分页查询请求参数
 */
@Data
public class ShortLinkRecycleBinPageDTO extends Page<ShortLinkDO> {

    /**
     * 短链接分组集合
     */
    private List<String> gidList;
}
