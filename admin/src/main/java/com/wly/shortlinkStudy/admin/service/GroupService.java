package com.wly.shortlinkStudy.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.admin.dao.entity.GroupDO;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupSaveReqDTO;

/**
 * 短连接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短连接分组
     * @param requestParam 短连接分组新增请求实体类
     */
    void saveGroup(ShortLinkGroupSaveReqDTO requestParam);
}
