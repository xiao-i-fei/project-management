package com.xiaofei.management.api.service;

import com.xiaofei.management.api.domain.ApiUserInterfaceInfo;

import java.util.List;

/**
 * 用户调用接口关系Service接口
 *
 * @author xiaofei
 * @date 2024-02-28
 */
public interface IApiUserInterfaceInfoService {
    /**
     * 查询用户调用接口关系
     *
     * @param id 用户调用接口关系主键
     * @return 用户调用接口关系
     */
    public ApiUserInterfaceInfo selectApiUserInterfaceInfoById(Long id);

    /**
     * 查询用户调用接口关系列表
     *
     * @param apiUserInterfaceInfo 用户调用接口关系
     * @return 用户调用接口关系集合
     */
    public List<ApiUserInterfaceInfo> selectApiUserInterfaceInfoList(ApiUserInterfaceInfo apiUserInterfaceInfo);

    /**
     * 新增用户调用接口关系
     *
     * @param apiUserInterfaceInfo 用户调用接口关系
     * @return 结果
     */
    public int insertApiUserInterfaceInfo(ApiUserInterfaceInfo apiUserInterfaceInfo);

    /**
     * 修改用户调用接口关系
     *
     * @param apiUserInterfaceInfo 用户调用接口关系
     * @return 结果
     */
    public int updateApiUserInterfaceInfo(ApiUserInterfaceInfo apiUserInterfaceInfo);

    /**
     * 批量删除用户调用接口关系
     *
     * @param ids 需要删除的用户调用接口关系主键集合
     * @return 结果
     */
    public int deleteApiUserInterfaceInfoByIds(Long[] ids);

    /**
     * 删除用户调用接口关系信息
     *
     * @param id 用户调用接口关系主键
     * @return 结果
     */
    public int deleteApiUserInterfaceInfoById(Long id);

    /**
     * 用户订阅接口，新增用户接口关联关系
     */
    boolean subscriptionInterfaceId(Long interfaceId);

    /**
     * 接口被删除时，删除接口与用户关联关系
     */
    int deleteByInterfaceId(Long[] interfaceIds);
}
