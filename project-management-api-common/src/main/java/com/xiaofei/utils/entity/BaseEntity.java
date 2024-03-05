package com.xiaofei.utils.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * User: XiaoFei
 * Date: 2023-03-06
 * Time: 16:07:47.152
 * Email: 1903078434@qq.com
 *
 * @author XiaoFei
 */
@Data
public class BaseEntity {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//返回json数据的时候不会携带该参数，但是请求的时候会接收该参数
    private Long pageNum = 1L;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//返回json数据的时候不会携带该参数，但是请求的时候会接收该参数
    private Long pageSize = 10L;
}
