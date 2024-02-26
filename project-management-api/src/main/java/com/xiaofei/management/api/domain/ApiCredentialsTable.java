package com.xiaofei.management.api.domain;

import com.xiaofei.management.common.annotation.Excel;
import com.xiaofei.management.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 凭据信息，存储访问密钥和密钥信息对象 api_credentials_table
 *
 * @author xiaofei
 * @date 2024-02-26
 */
@Data
public class ApiCredentialsTable extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 凭据ID，主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 访问密钥，不能为空
     */
    @Excel(name = "访问密钥，不能为空")
    private String accessKey;

    /**
     * 密钥，不能为空
     */
    @Excel(name = "密钥，不能为空")
    private String secretKey;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Long isDelete;
}
