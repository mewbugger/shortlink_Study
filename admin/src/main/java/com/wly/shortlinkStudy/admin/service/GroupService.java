package com.wly.shortlinkStudy.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wly.shortlinkStudy.admin.dao.entity.GroupDO;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.wly.shortlinkStudy.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * 短连接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短连接分组
     * @param
     */
    void saveGroup(String groupName);

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

    /**
     * 删除短连接分组
     * @param gid 短连接分组标识
     */
    void deleteGroup(String gid);

    /**
     * 短连接分组排序
     * @param requestParam 短连接分组排序参数
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
