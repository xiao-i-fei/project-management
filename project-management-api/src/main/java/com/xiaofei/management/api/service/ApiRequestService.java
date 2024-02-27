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
     * 根据条件查询用户信息
     */
    String listUserBySearch(ApiInterfaceRequestDTO apiInterfaceRequestDTO);
}
