package com.wly.shortlinkStudy.project.toolkit;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.wly.shortlinkStudy.project.common.constant.ShortLinkConstant;

import java.util.Date;
import java.util.Optional;

/**
 * 短链接工具类
 */
public class LinkUtil {

    /**获取短链接缓存有效期时间
     * @param validDate
     * @return 有效期时间戳
     */
    public static long getLinkCacheValidTime(Date validDate) {
        Long validTime = Optional.ofNullable(validDate)
                //如果有效期不是空，则获取当前时间和有效期的时间差值，即有效时间
                .map(each -> DateUtil.between(new Date(), each, DateUnit.MS))
                .orElse(ShortLinkConstant.DEFAULT_CACHE_VALID_TIME);
        System.out.println(validTime);
        return validTime;
    }
}
