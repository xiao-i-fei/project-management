package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;
import com.xiaofei.management.api.service.impl.ApiRequestServiceImpl;
import com.xiaofei.management.common.annotation.Anonymous;
import com.xiaofei.management.common.annotation.Log;
import com.xiaofei.management.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class ApiRequestController {

    @Autowired
    private ApiRequestServiceImpl apiRequestService;

    /**
     * 前端测试调用
     */
    @Log(title = "前端测试调用", businessType = BusinessType.DELETE)
    @PostMapping("test/request")
    public String testRequest(@RequestBody ApiInterfaceRequestDTO apiInterfaceRequestDTO) {
        return apiRequestService.testRequest(apiInterfaceRequestDTO);
    }

    /**
     * 国家地区查询【根据传递的参数进行分页查询】
     */
    @Anonymous
    @PostMapping("/region/list/page")
    public String regionListByPage(@RequestHeader("accessKey") String accessKey, @RequestBody String encryptData) {
        return apiRequestService.regionListByPage(accessKey, encryptData);
    }
}
