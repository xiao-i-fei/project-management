package com.xiaofei.management.api.mapper;

import com.xiaofei.management.api.domain.ApiInterfaceRequestInfo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 接口请求记录Mapper接口
 *
 * @author xiaofei
 * @date 2024-03-07
 */
public interface ApiInterfaceRequestInfoMapper {
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
     * 删除接口请求记录
     *
     * @param id 接口请求记录主键
     * @return 结果
     */
    public int deleteApiInterfaceRequestInfoById(Long id);

    /**
     * 批量删除接口请求记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApiInterfaceRequestInfoByIds(Long[] ids);

    /**
     * 定时生成最近指定天数调用接口次数数据
     */
    void generateRequestInfo(@Param("loopCount") Integer loopCount, @Param("localDate") LocalDate localDate);

    List<Map<String,String>> countRequestByDate();

    /**
     * 查询每个用户调用次数
     */
    List<Map<String,String>> userRequestCount();

    /**
     * 统计每个接口请求次数
     */
    List<Map<String,String>> countInterfaceRequest();

}
