package com.wly.shortlinkStudy.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.admin.dao.entity.GroupDO;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.wly.shortlinkStudy.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * 短连接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短连接分组
     * @param requestParam 短连接分组新增请求实体类
     */
    void saveGroup(ShortLinkGroupSaveReqDTO requestParam);

    /**
     * 查询用户短连接分组集合
     * @return
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 修改短连接分组名称
     * @param requestParam 修改短连接分组参数
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);
}
