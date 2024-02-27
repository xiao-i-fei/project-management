package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;
import com.xiaofei.management.api.service.impl.ApiRequestServiceImpl;
import com.xiaofei.management.common.annotation.Log;
import com.xiaofei.management.common.core.controller.BaseController;
import com.xiaofei.management.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ApiRequestController
 * Package: com.xiaofei.management.web.controller.api
 *
 * @Author: XiaoFei
 * @Create: 2024/2/27 22:06
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@RestController
@RequestMapping("interface")
public class ApiRequestController extends BaseController {

    @Autowired
    private ApiRequestServiceImpl apiRequestService;

    /**
     * 根据条件查询用户信息
     */
    @Log(title = "根据条件查询用户信息", businessType = BusinessType.DELETE)
    @PostMapping("user/list/search")
    public String listUserBySearch(@RequestBody ApiInterfaceRequestDTO apiInterfaceRequestDTO) {
        return apiRequestService.listUserBySearch(apiInterfaceRequestDTO);
    }
}
