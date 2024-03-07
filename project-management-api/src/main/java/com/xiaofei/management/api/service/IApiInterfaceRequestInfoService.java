package com.xiaofei.management.api.service;

import com.xiaofei.management.api.domain.ApiInterfaceRequestInfo;

import java.util.List;
import java.util.Map;

/**
 * 接口请求记录Service接口
 *
 * @author xiaofei
 * @date 2024-03-07
 */
public interface IApiInterfaceRequestInfoService {
    /**
     * 查询接口请求记录
     *
     * @param id 接口请求记录主键
     * @return 接口请求记录
     */
    public ApiInterfaceRequestInfo selectApiInterfaceRequestInfoById(Long id);

    /**
     * 查询接口请求记录列表
     *
     * @param apiInterfaceRequestInfo 接口请求记录
     * @return 接口请求记录集合
     */
    public List<ApiInterfaceRequestInfo> selectApiInterfaceRequestInfoList(ApiInterfaceRequestInfo apiInterfaceRequestInfo);

    /**
     * 新增接口请求记录
     *
     * @param apiInterfaceRequestInfo 接口请求记录
     * @return 结果
     */
    public int insertApiInterfaceRequestInfo(ApiInterfaceRequestInfo apiInterfaceRequestInfo);

    /**
     * 修改接口请求记录
     *
     * @param apiInterfaceRequestInfo 接口请求记录
     * @return 结果
     */
    public int updateApiInterfaceRequestInfo(ApiInterfaceRequestInfo apiInterfaceRequestInfo);

    /**
     * 批量删除接口请求记录
     *
     * @param ids 需要删除的接口请求记录主键集合
     * @return 结果
     */
    public int deleteApiInterfaceRequestInfoByIds(Long[] ids);

    /**
     * 删除接口请求记录信息
     *
     * @param id 接口请求记录主键
     * @return 结果
     */
    public int deleteApiInterfaceRequestInfoById(Long id);

    /**
     * 定时生成最近指定天数调用接口次数数据
     */
    void generateRequestInfo(Integer loopCount, Integer recentDays);

    /**
     * 统计查询
     */
    Map<String, Object> statisticalQuery();
}
