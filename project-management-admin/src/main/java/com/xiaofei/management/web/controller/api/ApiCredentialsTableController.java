package com.xiaofei.management.web.controller.api;

import com.xiaofei.management.api.domain.ApiCredentialsTable;
import com.xiaofei.management.api.service.IApiCredentialsTableService;
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
 * 凭据信息，存储访问密钥和密钥信息Controller
 *
 * @author xiaofei
 * @date 2024-02-26
 */
@RestController
@RequestMapping("/api/aksk")
public class ApiCredentialsTableController extends BaseController {
    @Autowired
    private IApiCredentialsTableService apiCredentialsTableService;

    /**
     * 查询凭据信息，存储访问密钥和密钥信息列表
     */
    @PreAuthorize("@ss.hasPermi('api:aksk:list')")
    @GetMapping("/list")
    public TableDataInfo list(ApiCredentialsTable apiCredentialsTable) {
        startPage();
        List<ApiCredentialsTable> list = apiCredentialsTableService.selectApiCredentialsTableList(apiCredentialsTable);
        return getDataTable(list);
    }

    /**
     * 导出凭据信息，存储访问密钥和密钥信息列表
     */
    @PreAuthorize("@ss.hasPermi('api:aksk:export')")
    @Log(title = "凭据信息，存储访问密钥和密钥信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ApiCredentialsTable apiCredentialsTable) {
        List<ApiCredentialsTable> list = apiCredentialsTableService.selectApiCredentialsTableList(apiCredentialsTable);
        ExcelUtil<ApiCredentialsTable> util = new ExcelUtil<ApiCredentialsTable>(ApiCredentialsTable.class);
        util.exportExcel(response, list, "凭据信息，存储访问密钥和密钥信息数据");
    }

    /**
     * 获取凭据信息，存储访问密钥和密钥信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('api:aksk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(apiCredentialsTableService.selectApiCredentialsTableById(id));
    }

    /**
     * 新增凭据信息，存储访问密钥和密钥信息
     */
    @PreAuthorize("@ss.hasPermi('api:aksk:add')")
    @Log(title = "凭据信息，存储访问密钥和密钥信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add() {
        return toAjax(apiCredentialsTableService.insertApiCredentialsTable());
    }

    /**
     * 修改凭据信息，存储访问密钥和密钥信息
     */
    @PreAuthorize("@ss.hasPermi('api:aksk:edit')")
    @Log(title = "凭据信息，存储访问密钥和密钥信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApiCredentialsTable apiCredentialsTable) {
        return toAjax(apiCredentialsTableService.updateApiCredentialsTable(apiCredentialsTable));
    }

    /**
     * 删除凭据信息，存储访问密钥和密钥信息
     */
    @PreAuthorize("@ss.hasPermi('api:aksk:remove')")
    @Log(title = "凭据信息，存储访问密钥和密钥信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(apiCredentialsTableService.deleteApiCredentialsTableByIds(ids));
    }
}
