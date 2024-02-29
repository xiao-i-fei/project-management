package com.xiaofei.management.api.service.impl;

import com.xiaofei.management.api.domain.ApiUserInterfaceInfo;
import com.xiaofei.management.api.mapper.ApiUserInterfaceInfoMapper;
import com.xiaofei.management.api.service.IApiUserInterfaceInfoService;
import com.xiaofei.management.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户调用接口关系Service业务层处理
 *
 * @author xiaofei
 * @date 2024-02-28
 */
@Service
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
}
