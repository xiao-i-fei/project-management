package com.xiaofei.management.api.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.xiaofei.management.api.domain.ApiUserInterfaceInfo;
import com.xiaofei.management.api.mapper.ApiUserInterfaceInfoMapper;
import com.xiaofei.management.api.service.IApiUserInterfaceInfoService;
import com.xiaofei.management.common.exception.ServiceException;
import com.xiaofei.management.common.utils.DateUtils;
import com.xiaofei.management.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户调用接口关系Service业务层处理
 *
 * @author xiaofei
 * @date 2024-02-28
 */
@Service
@Transactional
public class ApiUserInterfaceInfoServiceImpl implements IApiUserInterfaceInfoService {
    @Autowired
    private ApiUserInterfaceInfoMapper apiUserInterfaceInfoMapper;

    /**
     * 查询用户调用接口关系
     *
     * @param id 用户调用接口关系主键
     * @return 用户调用接口关系
     */
    @Override
    public ApiUserInterfaceInfo selectApiUserInterfaceInfoById(Long id) {
        return apiUserInterfaceInfoMapper.selectApiUserInterfaceInfoById(id);
    }

    /**
     * 查询用户调用接口关系列表
     *
     * @param apiUserInterfaceInfo 用户调用接口关系
     * @return 用户调用接口关系
     */
    @Override
    public List<ApiUserInterfaceInfo> selectApiUserInterfaceInfoList(ApiUserInterfaceInfo apiUserInterfaceInfo) {
        return apiUserInterfaceInfoMapper.selectApiUserInterfaceInfoList(apiUserInterfaceInfo);
    }

    /**
     * 新增用户调用接口关系
     *
     * @param apiUserInterfaceInfo 用户调用接口关系
     * @return 结果
     */
    @Override
    public int insertApiUserInterfaceInfo(ApiUserInterfaceInfo apiUserInterfaceInfo) {
        apiUserInterfaceInfo.setCreateTime(DateUtils.getNowDate());
        return apiUserInterfaceInfoMapper.insertApiUserInterfaceInfo(apiUserInterfaceInfo);
    }

    /**
     * 修改用户调用接口关系
     *
     * @param apiUserInterfaceInfo 用户调用接口关系
     * @return 结果
     */
    @Override
    public int updateApiUserInterfaceInfo(ApiUserInterfaceInfo apiUserInterfaceInfo) {
        apiUserInterfaceInfo.setUpdateTime(DateUtils.getNowDate());
        return apiUserInterfaceInfoMapper.updateApiUserInterfaceInfo(apiUserInterfaceInfo);
    }

    /**
     * 批量删除用户调用接口关系
     *
     * @param ids 需要删除的用户调用接口关系主键
     * @return 结果
     */
    @Override
    public int deleteApiUserInterfaceInfoByIds(Long[] ids) {
        return apiUserInterfaceInfoMapper.deleteApiUserInterfaceInfoByIds(ids);
    }

    /**
     * 删除用户调用接口关系信息
     *
     * @param id 用户调用接口关系主键
     * @return 结果
     */
    @Override
    public int deleteApiUserInterfaceInfoById(Long id) {
        return apiUserInterfaceInfoMapper.deleteApiUserInterfaceInfoById(id);
    }

    /**
     * 根据用户id和接口id查询接口用户关联关系
     */
    public ApiUserInterfaceInfo selectByUserIdAndInterfaceId(Long userId, Long interfaceId) {
        return apiUserInterfaceInfoMapper.selectByUserIdAndInterfaceId(userId, interfaceId);
    }

    /**
     * 用户订阅接口，新增用户接口关联关系
     */
    @Override
    public boolean subscriptionInterfaceId(Long interfaceId) {
        Long userId = SecurityUtils.getUserId();
        // 查询是否已订阅
        ApiUserInterfaceInfo resultUserInterfaceInfo = this.selectByUserIdAndInterfaceId(userId, interfaceId);
        if (!ObjectUtil.isEmpty(resultUserInterfaceInfo)) {
            throw new ServiceException("该接口已订阅，禁止重复订阅");
        }

        // 不为空  新增一条订阅数据
        ApiUserInterfaceInfo apiUserInterfaceInfo = new ApiUserInterfaceInfo();
        apiUserInterfaceInfo.setUserId(userId);
        apiUserInterfaceInfo.setInterfaceInfoId(interfaceId);
        apiUserInterfaceInfo.setTotalNum(1000L);
        apiUserInterfaceInfo.setLeftNum(1000L);
        return this.insertApiUserInterfaceInfo(apiUserInterfaceInfo) > 0;
    }

    /**
     * 接口被删除时，删除接口与用户关联关系
     */
    @Override
    public int deleteByInterfaceId(Long[] interfaceIds) {
        return apiUserInterfaceInfoMapper.deleteByInterfaceId(interfaceIds);
    }
}
