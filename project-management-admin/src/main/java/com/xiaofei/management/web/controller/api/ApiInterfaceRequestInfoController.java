package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.domain.ApiInterfaceRequestInfo;
import com.xiaofei.management.api.service.IApiInterfaceRequestInfoService;
import com.xiaofei.management.common.annotation.Anonymous;
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

/**
 * 接口请求记录Controller
 *
 * @author xiaofei
 * @date 2024-03-07
 */
@RestController
@RequestMapping("/api/interfaceRequestInfo")
public class ApiInterfaceRequestInfoController extends BaseController {
    @Autowired
    private IApiInterfaceRequestInfoService apiInterfaceRequestInfoService;

    /**
     * 查询接口请求记录列表
     */
    @PreAuthorize("@ss.hasPermi('api:interfaceRequestInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        startPage();
        List<ApiInterfaceRequestInfo> list = apiInterfaceRequestInfoService.selectApiInterfaceRequestInfoList(apiInterfaceRequestInfo);
        return getDataTable(list);
    }

    /**
     * 导出接口请求记录列表
     */
    @PreAuthorize("@ss.hasPermi('api:interfaceRequestInfo:export')")
    @Log(title = "接口请求记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        List<ApiInterfaceRequestInfo> list = apiInterfaceRequestInfoService.selectApiInterfaceRequestInfoList(apiInterfaceRequestInfo);
        ExcelUtil<ApiInterfaceRequestInfo> util = new ExcelUtil<ApiInterfaceRequestInfo>(ApiInterfaceRequestInfo.class);
        util.exportExcel(response, list, "接口请求记录数据");
    }

    /**
     * 获取接口请求记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('api:interfaceRequestInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(apiInterfaceRequestInfoService.selectApiInterfaceRequestInfoById(id));
    }

    /**
     * 新增接口请求记录
     */
    @PreAuthorize("@ss.hasPermi('api:interfaceRequestInfo:add')")
    @Log(title = "接口请求记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        return toAjax(apiInterfaceRequestInfoService.insertApiInterfaceRequestInfo(apiInterfaceRequestInfo));
    }

    /**
     * 修改接口请求记录
     */
    @PreAuthorize("@ss.hasPermi('api:interfaceRequestInfo:edit')")
    @Log(title = "接口请求记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        return toAjax(apiInterfaceRequestInfoService.updateApiInterfaceRequestInfo(apiInterfaceRequestInfo));
    }

    /**
     * 删除接口请求记录
     */
    @PreAuthorize("@ss.hasPermi('api:interfaceRequestInfo:remove')")
    @Log(title = "接口请求记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(apiInterfaceRequestInfoService.deleteApiInterfaceRequestInfoByIds(ids));
    }

    /**
     * 统计查询
     */
    @Anonymous
    @GetMapping("/statisticalQuery")
    public AjaxResult statisticalQuery() {
        return success(apiInterfaceRequestInfoService.statisticalQuery());
    }
}
