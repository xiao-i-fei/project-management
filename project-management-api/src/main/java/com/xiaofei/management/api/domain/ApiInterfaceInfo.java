package com.xiaofei.management.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xiaofei.management.common.annotation.Excel;
import com.xiaofei.management.common.core.domain.BaseEntity;

/**
 * 接口信息对象 api_interface_info
 *
 * @author xiaofei
 * @date 2024-02-26
 */
public class ApiInterfaceInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 接口地址
     */
    @Excel(name = "接口地址")
    private String url;

    /**
     * 请求参数
     */
    @Excel(name = "请求参数")
    private String requestParams;

    /**
     * 请求头
     */
    @Excel(name = "请求头")
    private String requestHeader;

    /**
     * 响应头
     */
    @Excel(name = "响应头")
    private String responseHeader;

    /**
     * 接口状态（0-关闭，1-开启）
     */
    @Excel(name = "接口状态", readConverterExp = "0=-关闭，1-开启")
    private Long status;

    /**
     * 请求类型
     */
    @Excel(name = "请求类型")
    private String method;

    /**
     * 创建人
     */
    private Long userId;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Long isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setResponseHeader(String responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getResponseHeader() {
        return responseHeader;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("description", getDescription())
                .append("url", getUrl())
                .append("requestParams", getRequestParams())
                .append("requestHeader", getRequestHeader())
                .append("responseHeader", getResponseHeader())
                .append("status", getStatus())
                .append("method", getMethod())
                .append("userId", getUserId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
