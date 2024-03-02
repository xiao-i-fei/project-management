package com.xiaofei.management.api.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.xiaofei.management.api.domain.ApiCredentialsTable;
import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;
import com.xiaofei.management.api.service.ApiRequestService;
import com.xiaofei.management.api.service.IApiCredentialsTableService;
import com.xiaofei.management.common.exception.ServiceException;
import com.xiaofei.management.common.utils.EncryptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
@Service
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private ApiInterfaceInfoServiceImpl apiInterfaceInfoService;

    @Autowired
    private IApiCredentialsTableService apiCredentialsTableService;

    @Value("${gatewayUrl}")
    private String gatewayUrl;

    /**
     * 前端测试调用
     */
    @Override
    public String testRequest(ApiInterfaceRequestDTO apiInterfaceRequestDTO) {
        String resp = "";

        try {
            ApiInterfaceInfo apiInterfaceInfo = apiInterfaceInfoService.selectApiInterfaceInfoById(apiInterfaceRequestDTO.getInterfaceId());

            String requestUrl = gatewayUrl + apiInterfaceInfo.getUrl();

            if (StringUtils.isEmpty(apiInterfaceRequestDTO.getJsonParam())) {
                resp = HttpUtil.get(requestUrl);
            } else {
                Map<String, Object> parse = JSON.parseObject(apiInterfaceRequestDTO.getJsonParam(), new TypeReference<Map<String, Object>>() {
                });
                resp = HttpUtil.get(requestUrl, parse);
            }

        } catch (Exception e) {
            throw new ServiceException("该接口暂不支持在线联调，请使用开发者SDK进行使用");
        }
        return resp;
    }

    /**
     * 国家地区查询【根据传递的参数进行分页查询】
     */
    @Override
    public String regionListByPage(String accessKey, String encryptData) {
        try {
            String secretKey = verifySecretKey(accessKey);
            // 参数解密
            String decrypt = EncryptionUtils.decrypt(encryptData, secretKey);
            String requestUrl = gatewayUrl + "/xiaofei-utils/region/list/page";

            return HttpUtil.get(requestUrl, JSON.parseObject(decrypt));
        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    private String verifySecretKey(String accessKey) {
        ApiCredentialsTable apiCredentialsTable = apiCredentialsTableService.selectApiCredentialsTableByAccessKey(accessKey);
        if (ObjectUtil.isEmpty(apiCredentialsTable) || StringUtils.isEmpty(apiCredentialsTable.getSecretKey())) {
            throw new ServiceException("accessKey和secretKey校验失败");
        }
        return apiCredentialsTable.getSecretKey();
    }
}
