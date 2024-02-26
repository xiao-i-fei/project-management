package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import com.xiaofei.management.api.service.IApiInterfaceInfoService;
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
 * 接口信息Controller
 *
 * @author xiaofei
 * @date 2024-02-26
 */
@RestController
@RequestMapping("/api/info")
public class ApiInterfaceInfoController extends BaseController {
    @Autowired
    private IApiInterfaceInfoService apiInterfaceInfoService;

    /**
     * 查询接口信息列表
     */
    @PreAuthorize("@ss.hasPermi('api:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApiInterfaceInfo apiInterfaceInfo) {
        startPage();
        List<ApiInterfaceInfo> list = apiInterfaceInfoService.selectApiInterfaceInfoList(apiInterfaceInfo);
        return getDataTable(list);
    }

    /**
     * 导出接口信息列表
     */
    @PreAuthorize("@ss.hasPermi('api:info:export')")
    @Log(title = "接口信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApiInterfaceInfo apiInterfaceInfo) {
        List<ApiInterfaceInfo> list = apiInterfaceInfoService.selectApiInterfaceInfoList(apiInterfaceInfo);
        ExcelUtil<ApiInterfaceInfo> util = new ExcelUtil<ApiInterfaceInfo>(ApiInterfaceInfo.class);
        util.exportExcel(response, list, "接口信息数据");
    }

    /**
     * 获取接口信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('api:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(apiInterfaceInfoService.selectApiInterfaceInfoById(id));
    }

    /**
     * 新增接口信息
     */
    @PreAuthorize("@ss.hasPermi('api:info:add')")
    @Log(title = "接口信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApiInterfaceInfo apiInterfaceInfo) {
        return toAjax(apiInterfaceInfoService.insertApiInterfaceInfo(apiInterfaceInfo));
    }

    /**
     * 修改接口信息
     */
    @PreAuthorize("@ss.hasPermi('api:info:edit')")
    @Log(title = "接口信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApiInterfaceInfo apiInterfaceInfo) {
        return toAjax(apiInterfaceInfoService.updateApiInterfaceInfo(apiInterfaceInfo));
    }

    /**
     * 删除接口信息
     */
    @PreAuthorize("@ss.hasPermi('api:info:remove')")
    @Log(title = "接口信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(apiInterfaceInfoService.deleteApiInterfaceInfoByIds(ids));
    }
}
