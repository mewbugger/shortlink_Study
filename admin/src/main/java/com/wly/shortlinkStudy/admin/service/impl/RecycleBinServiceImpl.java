package com.wly.shortlinkStudy.admin.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wly.shortlinkStudy.admin.common.biz.user.UserContext;
import com.wly.shortlinkStudy.admin.common.convention.exception.ServiceException;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.dao.entity.GroupDO;
import com.wly.shortlinkStudy.admin.dao.mapper.GroupMapper;
import com.wly.shortlinkStudy.admin.remote.dto.ShortLinkRemoteService;
import com.wly.shortlinkStudy.admin.remote.dto.req.ShortLinkRecycleBinPageDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.wly.shortlinkStudy.admin.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * url 回收站接口实现层
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements RecycleBinService {

    private final GroupMapper groupMapper;

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    @Override
    public Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageDTO requestParam) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if (!CollUtil.isNotEmpty(groupDOList)) {
            throw new ServiceException("用户无分组信息");
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        return shortLinkRemoteService.pageRecycleBinShortLink(requestParam);
    }
}
