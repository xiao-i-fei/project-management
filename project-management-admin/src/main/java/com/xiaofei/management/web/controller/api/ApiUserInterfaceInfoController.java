package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import com.xiaofei.management.api.domain.ApiUserInterfaceInfo;
import com.xiaofei.management.api.service.IApiInterfaceInfoService;
import com.xiaofei.management.api.service.IApiUserInterfaceInfoService;
import com.xiaofei.management.common.annotation.Log;
import com.xiaofei.management.common.core.controller.BaseController;
import com.xiaofei.management.common.core.domain.AjaxResult;
import com.xiaofei.management.common.core.page.TableDataInfo;
import com.xiaofei.management.common.enums.BusinessType;
import com.xiaofei.management.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户调用接口关系Controller
 *
 * @author xiaofei
 * @date 2024-02-28
 */
@RestController
@RequestMapping("/api/userInterfaceInfo")
public class ApiUserInterfaceInfoController extends BaseController {
    @Autowired
    private IApiUserInterfaceInfoService apiUserInterfaceInfoService;
    @Autowired
    private IApiInterfaceInfoService apiInterfaceInfoService;

    /**
     * 查询用户调用接口关系列表
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApiUserInterfaceInfo apiUserInterfaceInfo) {
        startPage();
        List<ApiUserInterfaceInfo> list = apiUserInterfaceInfoService.selectApiUserInterfaceInfoList(apiUserInterfaceInfo);
        list = list.stream().peek(item -> {
            ApiInterfaceInfo apiInterfaceInfo = apiInterfaceInfoService.selectApiInterfaceInfoById(item.getInterfaceInfoId());
            if (apiInterfaceInfo != null) {
                item.setInterfaceInfoName(apiInterfaceInfo.getName());
            }
        }).collect(Collectors.toList());
        return getDataTable(list);
    }

    /**
     * 导出用户调用接口关系列表
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:export')")
    @Log(title = "用户调用接口关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApiUserInterfaceInfo apiUserInterfaceInfo) {
        List<ApiUserInterfaceInfo> list = apiUserInterfaceInfoService.selectApiUserInterfaceInfoList(apiUserInterfaceInfo);
        ExcelUtil<ApiUserInterfaceInfo> util = new ExcelUtil<ApiUserInterfaceInfo>(ApiUserInterfaceInfo.class);
        util.exportExcel(response, list, "用户调用接口关系数据");
    }

    /**
     * 获取用户调用接口关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(apiUserInterfaceInfoService.selectApiUserInterfaceInfoById(id));
    }

    /**
     * 新增用户调用接口关系
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:add')")
    @Log(title = "用户调用接口关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApiUserInterfaceInfo apiUserInterfaceInfo) {
        return toAjax(apiUserInterfaceInfoService.insertApiUserInterfaceInfo(apiUserInterfaceInfo));
    }

    /**
     * 修改用户调用接口关系
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:edit')")
    @Log(title = "用户调用接口关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApiUserInterfaceInfo apiUserInterfaceInfo) {
        return toAjax(apiUserInterfaceInfoService.updateApiUserInterfaceInfo(apiUserInterfaceInfo));
    }

    /**
     * 删除用户调用接口关系
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:remove')")
    @Log(title = "用户调用接口关系", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(apiUserInterfaceInfoService.deleteApiUserInterfaceInfoByIds(ids));
    }

    /**
     * 用户订阅接口，新增用户接口关联关系
     */
    @PreAuthorize("@ss.hasPermi('api:userInterfaceInfo:subscription')")
    @Log(title = "用户订阅接口，新增用户接口关联关系", businessType = BusinessType.DELETE)
    @PostMapping("/subscription/{interfaceId}")
    public AjaxResult subscriptionInterfaceId(@PathVariable Long interfaceId) {
        boolean b = apiUserInterfaceInfoService.subscriptionInterfaceId(interfaceId);
        return AjaxResult.success(b ? "订阅成功" : "订阅失败", b);
    }
}
