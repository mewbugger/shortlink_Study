package com.wly.shortlinkStudy.project.service.impl;

import com.wly.shortlinkStudy.project.dto.req.ShortLinkStatsReqDTO;
import com.wly.shortlinkStudy.project.dto.resp.ShortLinkStatsRespDTO;
import com.wly.shortlinkStudy.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortLinkStatsServiceImpl implements ShortLinkStatsService {


    @Override
    public ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return null;
    }
}
