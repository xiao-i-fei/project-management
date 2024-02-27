package com.xiaofei.management.api.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;
import com.xiaofei.management.api.service.ApiRequestService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName: ApiRequestControllerImpl
 * Package: com.xiaofei.management.api.service.impl
 *
 * @Author: XiaoFei
 * @Create: 2024/2/27 22:08
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@Service
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private ApiInterfaceInfoServiceImpl apiInterfaceInfoService;

    /**
     * 根据条件查询用户信息
     */
    @Override
    public String listUserBySearch(ApiInterfaceRequestDTO apiInterfaceRequestDTO) {
        String resp = "";
        ApiInterfaceInfo apiInterfaceInfo = apiInterfaceInfoService.selectApiInterfaceInfoById(apiInterfaceRequestDTO.getInterfaceId());
        if (StringUtils.isEmpty(apiInterfaceRequestDTO.getJsonParam())) {
            resp = HttpUtil.get(apiInterfaceInfo.getUrl());
        } else {
            Map<String, Object> parse = JSON.parseObject(apiInterfaceRequestDTO.getJsonParam(), new TypeReference<Map<String, Object>>() {
            });
            resp = HttpUtil.get(apiInterfaceInfo.getUrl(), parse);
        }
        return resp;
    }
}
