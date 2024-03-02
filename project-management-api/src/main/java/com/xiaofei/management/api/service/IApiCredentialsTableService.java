package com.xiaofei.management.api.service;

import com.xiaofei.management.api.domain.ApiCredentialsTable;

import java.util.List;

/**
 * 凭据信息，存储访问密钥和密钥信息Service接口
 *
 * @author xiaofei
 * @date 2024-02-26
 */
public interface IApiCredentialsTableService {
    /**
     * 查询凭据信息，存储访问密钥和密钥信息
     *
     * @param id 凭据信息，存储访问密钥和密钥信息主键
     * @return 凭据信息，存储访问密钥和密钥信息
     */
    public ApiCredentialsTable selectApiCredentialsTableById(Long id);

    /**
     * 查询凭据信息
     *
     * @param accessKey 凭据信息accessKey
     * @return 凭据信息，存储访问密钥和密钥信息
     */
    public ApiCredentialsTable selectApiCredentialsTableByAccessKey(String accessKey);

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
     * @return 结果
     */
    public int insertApiCredentialsTable();

    /**
     * 修改凭据信息，存储访问密钥和密钥信息
     *
     * @param apiCredentialsTable 凭据信息，存储访问密钥和密钥信息
     * @return 结果
     */
    public int updateApiCredentialsTable(ApiCredentialsTable apiCredentialsTable);

    /**
     * 批量删除凭据信息，存储访问密钥和密钥信息
     *
     * @param ids 需要删除的凭据信息，存储访问密钥和密钥信息主键集合
     * @return 结果
     */
    public int deleteApiCredentialsTableByIds(Long[] ids);

    /**
     * 删除凭据信息，存储访问密钥和密钥信息信息
     *
     * @param id 凭据信息，存储访问密钥和密钥信息主键
     * @return 结果
     */
    public int deleteApiCredentialsTableById(Long id);
}
