package com.wly.shortlinkStudy.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wly.shortlinkStudy.project.dao.entity.ShortLinkGotoDO;
import com.wly.shortlinkStudy.project.dao.mapper.ShortLinkGotoMapper;
import com.wly.shortlinkStudy.project.service.ShortLinkGotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShortLinkGotoServiceImpl extends ServiceImpl<ShortLinkGotoMapper, ShortLinkGotoDO> implements ShortLinkGotoService {
}
