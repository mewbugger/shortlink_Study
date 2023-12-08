package com.wly.shortlinkStudy.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wly.shortlinkStudy.admin.common.biz.user.UserContext;
import com.wly.shortlinkStudy.admin.common.constant.RedisCacheConstant;
import com.wly.shortlinkStudy.admin.common.convention.exception.ClientException;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.dao.entity.GroupDO;
import com.wly.shortlinkStudy.admin.dao.mapper.GroupMapper;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.wly.shortlinkStudy.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.wly.shortlinkStudy.admin.dto.resp.ShortLinkGroupRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.ShortLinkRemoteService;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.wly.shortlinkStudy.admin.service.GroupService;
import com.wly.shortlinkStudy.admin.toolkit.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 短连接分组接口实现层
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    private final RedissonClient redissonClient;

    @Value("${short-link.group.max-num}")
    private Integer groupMaxNum;

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    @Override
    public void saveGroup(String groupName) {
        savaGroup(UserContext.getUsername(), groupName);
    }

    @Override
    public void savaGroup(String username, String groupName) {
        RLock lock = redissonClient.getLock(String.format(RedisCacheConstant.LOCK_GROUP_CREATE_KEY, username));
        lock.lock();
        try {
            LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                    .eq(GroupDO::getUsername, username)
                    .eq(GroupDO::getDelFlag, 0);
            List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
            if (CollUtil.isNotEmpty(groupDOList) && groupDOList.size() == groupMaxNum) {
                throw new ClientException(String.format("已超出最大分组数:%d", groupMaxNum));
            }
            String gid;
            // 反复生成随机的gid直到gid不重复
            while (true) {
                gid = RandomGenerator.generateRandom();
                if (hasGid(username, gid)) {
                    break;
                }
            }
            GroupDO groupDO = GroupDO.builder()
                    .gid(gid)
                    .sortOrder(0)
                    .username(username)
                    .name(groupName)
                    .build();

            baseMapper.insert(groupDO);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);
        //查到当前用户的所有短链接分组列表
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        //通过当前用户的gid列表获取ShortLinkGroupCountQueryRespDTO（包含gid和shortLinkCount）的列表
        Result<List<ShortLinkGroupCountQueryRespDTO>> listResult = shortLinkRemoteService
                //将 groupDOList 中每个 GroupDO 对象的 gid 属性提取出来，并形成一个新的列表
                //map(GroupDO::getGid) 是一个映射操作，它会将流中的每个 GroupDO 对象映射为其 gid 属性。
                //groupDOList.stream().map(GroupDO::getGid).toList()==获取当前用户的所有短链接分组的分组标识，并将它们存到一个列表里面
                .listGroupShortLinkCount(groupDOList.stream().map(GroupDO::getGid).toList());
        //将当前用户的所有短链接分组列表转换成（请求当前用户所有分组返回参数列表，返回参数中的属性有gid和shortLinkCount）
        List<ShortLinkGroupRespDTO> shortLinkGroupRespDTOList = BeanUtil.copyToList(groupDOList, ShortLinkGroupRespDTO.class);
        //通过ShortLinkGroupCountQueryRespDTO列表，来补齐shortLinkGroupRespDTOList列表中缺少的shortLinkCount
        shortLinkGroupRespDTOList.forEach(each -> {
            Optional<ShortLinkGroupCountQueryRespDTO> first = listResult.getData().stream()
                    .filter(item -> Objects.equals(item.getGid(), each.getGid()))
                    //其实本质上就是只有一个，findFirst只是为了获取该元素
                    .findFirst();
            //如果存在，将ShortLinkGroupCountQueryRespDTO中的shortLinkCount赋值给shortLinkGroupRespDTO（即下面的each）
            first.ifPresent(item -> each.setShortLinkCount(first.get().getShortLinkCount()));
        });
        return shortLinkGroupRespDTOList;
    }

    @Override
    public void updateGroup(ShortLinkGroupUpdateReqDTO requestParam) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, requestParam.getGid())
                .eq(GroupDO::getDelFlag, 0);
        GroupDO groupDO = new GroupDO();
        groupDO.setName(requestParam.getName());
        baseMapper.update(groupDO, updateWrapper);
    }

    @Override
    public void deleteGroup(String gid) {
        LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getDelFlag, 0);
        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(1);
        baseMapper.update(groupDO, updateWrapper);
    }

    @Override
    public void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam) {
        requestParam.forEach(each -> {
            GroupDO groupDO = GroupDO.builder()
                    .sortOrder(each.getSortOrder())
                    .build();
            LambdaUpdateWrapper<GroupDO> updateWrapper = Wrappers.lambdaUpdate(GroupDO.class)
                    .eq(GroupDO::getUsername, UserContext.getUsername())
                    .eq(GroupDO::getGid, each.getGid())
                    .eq(GroupDO::getDelFlag, 0);
            baseMapper.update(groupDO, updateWrapper);
        });

    }

    /**
     * 判断随机生成的gid是否已经存在
     *
     * @param gid
     * @return
     */
    private boolean hasGid(String username, String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getId, gid)
                .eq(GroupDO::getUsername, Optional.ofNullable(username).orElse(UserContext.getUsername()));
        GroupDO hasGroupFlag = baseMapper.selectOne(queryWrapper);
        return hasGroupFlag == null;
    }
}
