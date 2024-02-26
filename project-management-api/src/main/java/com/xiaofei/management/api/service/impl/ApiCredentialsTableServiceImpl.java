package com.xiaofei.management.api.service.impl;

import com.xiaofei.management.api.domain.ApiCredentialsTable;
import com.xiaofei.management.api.mapper.ApiCredentialsTableMapper;
import com.xiaofei.management.api.service.IApiCredentialsTableService;
import com.xiaofei.management.common.utils.DateUtils;
import com.xiaofei.management.common.utils.SecurityUtils;
import com.xiaofei.management.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 凭据信息，存储访问密钥和密钥信息Service业务层处理
 *
 * @author xiaofei
 * @date 2024-02-26
 */
@Service
@Transactional
public class ApiCredentialsTableServiceImpl implements IApiCredentialsTableService {
    @Autowired
    private ApiCredentialsTableMapper apiCredentialsTableMapper;

    /**
     * 查询凭据信息，存储访问密钥和密钥信息
     *
     * @param id 凭据信息，存储访问密钥和密钥信息主键
     * @return 凭据信息，存储访问密钥和密钥信息
     */
    @Override
    public ApiCredentialsTable selectApiCredentialsTableById(Long id) {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();

        return apiCredentialsTableMapper.selectApiCredentialsTableById(id, userId);
    }

    /**
     * 查询凭据信息，存储访问密钥和密钥信息列表
     *
     * @param apiCredentialsTable 凭据信息，存储访问密钥和密钥信息
     * @return 凭据信息，存储访问密钥和密钥信息
     */
    @Override
    public List<ApiCredentialsTable> selectApiCredentialsTableList(ApiCredentialsTable apiCredentialsTable) {
        // 获取当前用户ID
        apiCredentialsTable.setUserId(SecurityUtils.getUserId());

        return apiCredentialsTableMapper.selectApiCredentialsTableList(apiCredentialsTable);
    }

    /**
     * 新增凭据信息，存储访问密钥和密钥信息
     *
     * @return 结果
     */
    @Override
    public int insertApiCredentialsTable() {
        // 获取当前用户ID
        Long userid = SecurityUtils.getUserId();

        ApiCredentialsTable apiCredentialsTable = new ApiCredentialsTable();
        apiCredentialsTable.setUserId(userid);
        apiCredentialsTable.setAccessKey(IdUtils.fastSimpleUUID());
        apiCredentialsTable.setSecretKey(IdUtils.fastSimpleUUID());
        apiCredentialsTable.setCreateTime(DateUtils.getNowDate());
        return apiCredentialsTableMapper.insertApiCredentialsTable(apiCredentialsTable);
    }

    /**
     * 修改凭据信息，存储访问密钥和密钥信息
     *
     * @param apiCredentialsTable 凭据信息，存储访问密钥和密钥信息
     * @return 结果
     */
    @Override
    public int updateApiCredentialsTable(ApiCredentialsTable apiCredentialsTable) {
        // 获取当前用户ID
        apiCredentialsTable.setUserId(SecurityUtils.getUserId());

        apiCredentialsTable.setUpdateTime(DateUtils.getNowDate());
        return apiCredentialsTableMapper.updateApiCredentialsTable(apiCredentialsTable);
    }

    /**
     * 批量删除凭据信息，存储访问密钥和密钥信息
     *
     * @param ids 需要删除的凭据信息，存储访问密钥和密钥信息主键
     * @return 结果
     */
    @Override
    public int deleteApiCredentialsTableByIds(Long[] ids) {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();
        return apiCredentialsTableMapper.deleteApiCredentialsTableByIds(ids, userId);
    }

    /**
     * 删除凭据信息，存储访问密钥和密钥信息信息
     *
     * @param id 凭据信息，存储访问密钥和密钥信息主键
     * @return 结果
     */
    @Override
    public int deleteApiCredentialsTableById(Long id) {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();
        return apiCredentialsTableMapper.deleteApiCredentialsTableById(id, userId);
    }
}
