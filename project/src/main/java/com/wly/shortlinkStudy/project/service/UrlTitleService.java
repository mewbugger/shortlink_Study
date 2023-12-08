package com.wly.shortlinkStudy.project.service;

/**
 * URL接口层
 */
public interface UrlTitleService {

    /**
     * 根据url获取对应网站的标题
     * @param url
     * @return
     */
    String getTitleByUrl(String url);
}
