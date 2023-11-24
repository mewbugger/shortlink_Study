package com.wly.shortlinkStudy.admin.remote.dto;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wly.shortlinkStudy.admin.common.convention.result.Result;
import com.wly.shortlinkStudy.admin.common.convention.result.Results;
import com.wly.shortlinkStudy.admin.remote.dto.req.*;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.wly.shortlinkStudy.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短链接中台远程调用服务
 */
public interface ShortLinkRemoteService {

    /**
     * 创建短链接
     * @param requestParam 创建短链接请求参数
     * @return
     */
    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam) {
        String resultBody = HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBody, new TypeReference<>() {
        });
    }

    default Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/update", JSON.toJSONString(requestParam));
        return Results.success();
    }


    /**
     * 分页查询短链接
     * @param requestParam 分页查询短链接请求参数
     * @return
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        //由于中台提供的是get方法，所以这里使用Map，Map作为参数可以直接序列化到路径上面
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gid", requestParam.getGid());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/page", requestMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 查询分组短链接的数量
     * @param requestParam
     * @return
     */
    default Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam", requestParam);
        String resultStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/count", requestMap);
        return JSON.parseObject(resultStr, new TypeReference<>() {
        });
    }


    /**
     * 保存回收站
     * @param requestParam
     * @return
     */
    default void saveRecycleBin(RecycleBinSaveReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/save", JSON.toJSONString(requestParam));
    }

    /**
     * 分页查询回收站短链接
     * @param requestParam 分页查询回收站短链接请求参数
     * @return
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageDTO requestParam) {
        //由于中台提供的是get方法，所以这里使用Map，Map作为参数可以直接序列化到路径上面
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gidList", requestParam.getGidList());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/page", requestMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 恢复短链接
     * @param requestParam 恢复短链接请求参数
     */
    default void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/recycle-bin/recover", JSON.toJSONString(requestParam));
    }
}
