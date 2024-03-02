package com.xiaofei.management.api.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xiaofei.management.common.annotation.Excel;
import com.xiaofei.management.common.core.domain.BaseEntity;

/**
 * 用户调用接口关系对象 api_user_interface_info
 *
 * @author xiaofei
 * @date 2024-02-28
 */
public class ApiUserInterfaceInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    @Excel(name = "接口 id")
    private Long interfaceInfoId;

    /**
     * 接口名称
     */
    @Excel(name = "接口名称")
    private String interfaceInfoName;

    /**
     * 总调用次数
     */
    @Excel(name = "总调用次数")
    private Long totalNum;

    /**
     * 剩余调用次数
     */
    @Excel(name = "剩余调用次数")
    private Long leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Long status;

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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setInterfaceInfoId(Long interfaceInfoId) {
        this.interfaceInfoId = interfaceInfoId;
    }

    public Long getInterfaceInfoId() {
        return interfaceInfoId;
    }

    public String getInterfaceInfoName() {
        return interfaceInfoName;
    }

    public void setInterfaceInfoName(String interfaceInfoName) {
        this.interfaceInfoName = interfaceInfoName;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setLeftNum(Long leftNum) {
        this.leftNum = leftNum;
    }

    public Long getLeftNum() {
        return leftNum;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
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
                .append("userId", getUserId())
                .append("interfaceInfoId", getInterfaceInfoId())
                .append("interfaceInfoName", getInterfaceInfoName())
                .append("totalNum", getTotalNum())
                .append("leftNum", getLeftNum())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
