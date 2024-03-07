package com.xiaofei.management.api.domain;

import com.xiaofei.management.common.annotation.Excel;
import com.xiaofei.management.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 接口请求记录对象 api_interface_request_info
 *
 * @author xiaofei
 * @date 2024-03-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApiInterfaceRequestInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 调用用户 id
     */
    @Excel(name = "调用用户 id")
    private Long userId;

    /**
     * 接口地址
     */
    @Excel(name = "接口地址")
    private String interfacePath;

    /**
     * 请求类型
     */
    @Excel(name = "请求类型")
    private String method;

    /**
     * 接口描述
     */
    @Excel(name = "接口描述")
    private String describe;

    /**
     * 0-正常，1-禁用
     */
    private Long status;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Long isDelete;

    public ApiInterfaceRequestInfo(Long userId, String interfacePath,String method, String describe, Date createTime) {
        this.userId = userId;
        this.interfacePath = interfacePath;
        this.method = method;
        this.describe = describe;
        super.setCreateTime(createTime);
    }
}
