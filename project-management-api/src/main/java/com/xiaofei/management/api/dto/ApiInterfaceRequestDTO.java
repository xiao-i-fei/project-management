package com.xiaofei.management.api.dto;

import lombok.Data;

/**
 * ClassName: ApiInterfaceRequestDTO
 * Package: com.xiaofei.management.api.dto
 *
 * @Author: XiaoFei
 * @Create: 2024/2/27 21:54
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
@Data
public class ApiInterfaceRequestDTO {
    /**
     * 接口id
     */
    private Long interfaceId;

    /**
     * json参数
     */
    private String jsonParam;
}
