package com.xiaofei.management.api.mapper;

import com.xiaofei.management.api.domain.ApiUserInterfaceInfo;

import java.util.List;

/**
 * 用户调用接口关系Mapper接口
 *
 * @author xiaofei
 * @date 2024-02-28
 */
public interface ApiUserInterfaceInfoMapper {
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
     * 删除用户调用接口关系
     *
     * @param id 用户调用接口关系主键
     * @return 结果
     */
    public int deleteApiUserInterfaceInfoById(Long id);

    /**
     * 批量删除用户调用接口关系
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApiUserInterfaceInfoByIds(Long[] ids);
}
