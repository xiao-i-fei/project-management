package com.xiaofei.management.api.service;

import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;

/**
 * ClassName: ApiRequestController
 * Package: com.xiaofei.management.api.service
 *
 * @Author: XiaoFei
 * @Create: 2024/2/27 22:08
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
public interface ApiRequestService {

    /**
     * 前端测试调用
     */
    String testRequest(ApiInterfaceRequestDTO apiInterfaceRequestDTO);

    /**
     * 国家地区查询【根据传递的参数进行分页查询】
     */
    String regionListByPage(String accessKey, String encryptData);
}
