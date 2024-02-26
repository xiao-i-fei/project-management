package com.xiaofei.management.api.mapper;

import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口信息Mapper接口
 *
 * @author xiaofei
 * @date 2024-02-26
 */
public interface ApiInterfaceInfoMapper {
    /**
     * 查询接口信息
     *
     * @param id 接口信息主键
     * @return 接口信息
     */
    public ApiInterfaceInfo selectApiInterfaceInfoById(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 查询接口信息列表
     *
     * @param apiInterfaceInfo 接口信息
     * @return 接口信息集合
     */
    public List<ApiInterfaceInfo> selectApiInterfaceInfoList(ApiInterfaceInfo apiInterfaceInfo);

    /**
     * 新增接口信息
     *
     * @param apiInterfaceInfo 接口信息
     * @return 结果
     */
    public int insertApiInterfaceInfo(ApiInterfaceInfo apiInterfaceInfo);

    /**
     * 修改接口信息
     *
     * @param apiInterfaceInfo 接口信息
     * @return 结果
     */
    public int updateApiInterfaceInfo(ApiInterfaceInfo apiInterfaceInfo);

    /**
     * 删除接口信息
     *
     * @param id 接口信息主键
     * @return 结果
     */
    public int deleteApiInterfaceInfoById(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 批量删除接口信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApiInterfaceInfoByIds(@Param("ids") Long[] ids, @Param("userId") Long userId);
}
