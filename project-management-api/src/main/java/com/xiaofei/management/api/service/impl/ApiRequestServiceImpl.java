package com.xiaofei.management.api.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.xiaofei.management.api.domain.ApiCredentialsTable;
import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import com.xiaofei.management.api.domain.ApiInterfaceRequestInfo;
import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;
import com.xiaofei.management.api.service.ApiRequestService;
import com.xiaofei.management.api.service.IApiCredentialsTableService;
import com.xiaofei.management.api.service.IApiInterfaceRequestInfoService;
import com.xiaofei.management.common.enums.HttpMethod;
import com.xiaofei.management.common.exception.ServiceException;
import com.xiaofei.management.common.utils.DateUtils;
import com.xiaofei.management.common.utils.EncryptionUtils;
import com.xiaofei.utils.entity.RegionEntity;
import com.xiaofei.utils.service.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private ApiInterfaceInfoServiceImpl apiInterfaceInfoService;

    @Autowired
    private IApiCredentialsTableService apiCredentialsTableService;

    @Autowired
    private IApiInterfaceRequestInfoService apiInterfaceRequestInfoService;

    @DubboReference
    private RegionService regionService;

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
            log.info("接口在线调用错误：{}", e.getMessage());
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

            String resp = HttpUtil.get(requestUrl, JSON.parseObject(decrypt));

            ThreadUtil.execAsync(() -> requestCount("/region/list/page", "国家地区查询【根据传递的参数进行分页查询】", HttpMethod.GET.name(), accessKey));

            requestCount("/region/list/page", "国家地区查询【根据传递的参数进行分页查询】", HttpMethod.GET.name(), accessKey);
            return resp;
        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 根据id查询
     *
     * @return 指定条件数据
     */
    @Override
    public String selectRegionById(String accessKey, String encryptData) {
        try {
            String secretKey = verifySecretKey(accessKey);
            // 参数解密
            String decrypt = EncryptionUtils.decrypt(encryptData, secretKey);

            String jsonString = JSON.toJSONString(regionService.selectById(Long.parseLong(decrypt)));

            ThreadUtil.execAsync(() -> requestCount("/region/{id}", "国家地区查询【根据id查询】", HttpMethod.GET.name(), accessKey));

            return jsonString;

        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 根据传递的参数查询单条数据
     *
     * @return 指定条件的数据
     */
    @Override
    public String selectRegionOne(String accessKey, String encryptData) {
        try {
            String secretKey = verifySecretKey(accessKey);
            // 参数解密
            String decrypt = EncryptionUtils.decrypt(encryptData, secretKey);

            RegionEntity regionEntity = JSON.parseObject(decrypt, RegionEntity.class);

            String jsonString = JSON.toJSONString(regionService.selectOne(regionEntity));

            ThreadUtil.execAsync(() -> requestCount("/region/one", "国家地区查询【根据传递的参数查询单条数据】", HttpMethod.GET.name(), accessKey));

            return jsonString;

        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    @Override
    public String selectRegionList(String accessKey) {
        try {
            String secretKey = verifySecretKey(accessKey);

            String jsonString = JSON.toJSONString(regionService.selectList());

            ThreadUtil.execAsync(() -> requestCount("/region/list", "国家地区查询【查询全部】", HttpMethod.GET.name(), accessKey));

            return jsonString;

        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 查询全部，结果为树形结构
     *
     * @return 全部数据，树形结构
     */
    @Override
    public String selectRegionListTree(String accessKey) {
        try {
            verifySecretKey(accessKey);

            String jsonString = JSON.toJSONString(regionService.selectListTree());

            ThreadUtil.execAsync(() -> requestCount("/region/tree", "国家地区查询【查询全部，结果为树形结构】", HttpMethod.GET.name(), accessKey));

            return jsonString;

        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 根据条件查询
     *
     * @return 满足条件的信息
     */
    @Override
    public String listRegionBySearch(String accessKey, String encryptData) {
        try {
            String secretKey = verifySecretKey(accessKey);
            // 参数解密
            String decrypt = EncryptionUtils.decrypt(encryptData, secretKey);

            RegionEntity regionEntity = JSON.parseObject(decrypt, RegionEntity.class);

            String jsonString = JSON.toJSONString(regionService.listBySearch(regionEntity));

            ThreadUtil.execAsync(() -> requestCount("/region/list/search", "国家地区查询【根据条件查询】", HttpMethod.GET.name(), accessKey));

            return jsonString;
        } catch (Exception e) {
            log.error("国家地区查询【根据传递的参数进行分页查询】   接口调用错误，错误信息：{}", e.getMessage());
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * 根据accessKey获取secretKey
     */
    private String verifySecretKey(String accessKey) {
        ApiCredentialsTable apiCredentialsTable = apiCredentialsTableService.selectApiCredentialsTableByAccessKey(accessKey);
        if (ObjectUtil.isEmpty(apiCredentialsTable) || StringUtils.isEmpty(apiCredentialsTable.getSecretKey())) {
            throw new ServiceException("accessKey和secretKey校验失败");
        }
        return apiCredentialsTable.getSecretKey();
    }

    /**
     * 根据accessKey获取用户id
     */
    private Long getUserIdByAccessKey(String accessKey) {
        ApiCredentialsTable apiCredentialsTable = apiCredentialsTableService.selectApiCredentialsTableByAccessKey(accessKey);
        if (ObjectUtil.isEmpty(apiCredentialsTable) || StringUtils.isEmpty(apiCredentialsTable.getSecretKey())) {
            throw new ServiceException("accessKey和secretKey校验失败");
        }
        return apiCredentialsTable.getUserId();
    }

    private void requestCount(String path, String describe, String method, String accessKey) {
        Long userId = getUserIdByAccessKey(accessKey);
        ApiInterfaceRequestInfo apiInterfaceRequestInfo = new ApiInterfaceRequestInfo(userId, path, method, describe, DateUtils.getNowDate());
        apiInterfaceRequestInfo.setUserId(userId);
        apiInterfaceRequestInfoService.insertApiInterfaceRequestInfo(apiInterfaceRequestInfo);
    }
}
