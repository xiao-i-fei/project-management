package com.xiaofei.management.api.mapper;

import com.xiaofei.management.api.domain.ApiCredentialsTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 凭据信息，存储访问密钥和密钥信息Mapper接口
 * 
 * @author xiaofei
 * @date 2024-02-26
 */
public interface ApiCredentialsTableMapper 
{
    /**
     * 查询凭据信息，存储访问密钥和密钥信息
     *
     * @param id     凭据信息，存储访问密钥和密钥信息主键
     * @param userId 用户id
     * @return 凭据信息，存储访问密钥和密钥信息
     */
    public ApiCredentialsTable selectApiCredentialsTableById(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 查询凭据信息，存储访问密钥和密钥信息列表
     * 
     * @param apiCredentialsTable 凭据信息，存储访问密钥和密钥信息
     * @return 凭据信息，存储访问密钥和密钥信息集合
     */
    public List<ApiCredentialsTable> selectApiCredentialsTableList(ApiCredentialsTable apiCredentialsTable);

    /**
     * 新增凭据信息，存储访问密钥和密钥信息
     * 
     * @param apiCredentialsTable 凭据信息，存储访问密钥和密钥信息
     * @return 结果
     */
    public int insertApiCredentialsTable(ApiCredentialsTable apiCredentialsTable);

    /**
     * 修改凭据信息，存储访问密钥和密钥信息
     * 
     * @param apiCredentialsTable 凭据信息，存储访问密钥和密钥信息
     * @return 结果
     */
    public int updateApiCredentialsTable(ApiCredentialsTable apiCredentialsTable);

    /**
     * 删除凭据信息，存储访问密钥和密钥信息
     * 
     * @param id 凭据信息，存储访问密钥和密钥信息主键
     * @return 结果
     */
    public int deleteApiCredentialsTableById(@Param("id") Long id, @Param("userId") Long userId);

    /**
     * 批量删除凭据信息，存储访问密钥和密钥信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApiCredentialsTableByIds(@Param("ids") Long[] ids, @Param("userId") Long userId);
}
