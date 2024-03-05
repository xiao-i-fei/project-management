package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;
import com.xiaofei.management.api.service.ApiRequestService;
import com.xiaofei.management.common.annotation.Anonymous;
import com.xiaofei.management.common.annotation.Log;
import com.xiaofei.management.common.enums.BusinessType;
import com.xiaofei.utils.service.RegionService;
import org.apache.dubbo.config.annotation.DubboReference;
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
    private ApiRequestService apiRequestService;

    @DubboReference
    private RegionService regionService;

    /**
     * 前端测试调用
     */
    @Log(title = "前端测试调用", businessType = BusinessType.OTHER)
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

    /**
     * 根据id查询
     *
     * @return 指定条件数据
     */
    @Anonymous
    @PostMapping("region")
    public String selectRegionById(@RequestHeader("accessKey") String accessKey, @RequestBody String encryptData) {
        return apiRequestService.selectRegionById(accessKey, encryptData);
    }

    /**
     * 根据传递的参数查询单条数据
     *
     * @return 指定条件的数据
     */
    @Anonymous
    @PostMapping("region/one")
    public String selectRegionOne(@RequestHeader("accessKey") String accessKey, @RequestBody String encryptData) {
        return apiRequestService.selectRegionOne(accessKey, encryptData);
    }

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    @Anonymous
    @PostMapping("region/list")
    public String selectRegionList(@RequestHeader("accessKey") String accessKey) {
        return apiRequestService.selectRegionList(accessKey);
    }

    /**
     * 查询全部，结果为树形结构
     *
     * @return 全部数据，树形结构
     */
    @Anonymous
    @PostMapping("region/tree")
    public String selectRegionListTree(@RequestHeader("accessKey") String accessKey) {
        return apiRequestService.selectRegionListTree(accessKey);
    }

    /**
     * 根据条件查询
     *
     * @return 满足条件的信息
     */
    @Anonymous
    @PostMapping("region/list/search")
    public String listRegionBySearch(@RequestHeader("accessKey") String accessKey, @RequestBody String encryptData) {
        return apiRequestService.listRegionBySearch(accessKey, encryptData);
    }
}
