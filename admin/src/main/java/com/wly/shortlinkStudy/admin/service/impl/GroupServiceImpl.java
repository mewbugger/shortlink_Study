package com.wly.shortlinkStudy.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wly.shortlinkStudy.admin.dao.entity.GroupDO;
import com.wly.shortlinkStudy.admin.dao.mapper.GroupMapper;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.wly.shortlinkStudy.admin.service.GroupService;
import com.wly.shortlinkStudy.admin.toolkit.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 短连接分组接口实现层
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    @Override
    public void saveGroup(ShortLinkGroupSaveReqDTO requestParam) {
        String gid;
        // 反复生成随机的gid直到gid不重复
        while (true) {
            gid = RandomGenerator.generateRandom();
            if (hasGid(gid)) {
                break;
            }
        }
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(requestParam.getName())
                .sortOrder(0)
                .build();

        baseMapper.insert(groupDO);
    }

    /**
     * 判断随机生成的gid是否已经存在
     *
     * @param gid
     * @return
     */
    private boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getId, gid)
                // TODO 设置用户名
                .eq(GroupDO::getUsername, null);
        GroupDO hasGroupFlag = baseMapper.selectOne(queryWrapper);
        return hasGroupFlag == null;
    }
}
