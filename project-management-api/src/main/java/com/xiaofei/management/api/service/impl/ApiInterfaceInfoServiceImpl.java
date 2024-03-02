package com.xiaofei.management.api.service.impl;

import com.xiaofei.management.api.domain.ApiInterfaceInfo;
import com.xiaofei.management.api.mapper.ApiInterfaceInfoMapper;
import com.xiaofei.management.api.service.IApiInterfaceInfoService;
import com.xiaofei.management.api.service.IApiUserInterfaceInfoService;
import com.xiaofei.management.common.utils.DateUtils;
import com.xiaofei.management.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 接口信息Service业务层处理
 *
 * @author xiaofei
 * @date 2024-02-26
 */
@Service
@Transactional
public class ApiInterfaceInfoServiceImpl implements IApiInterfaceInfoService {
    @Autowired
    private ApiInterfaceInfoMapper apiInterfaceInfoMapper;

    @Autowired
    private IApiUserInterfaceInfoService apiUserInterfaceInfoService;

    /**
     * 查询接口信息
     *
     * @param id 接口信息主键
     * @return 接口信息
     */
    @Override
    public ApiInterfaceInfo selectApiInterfaceInfoById(Long id) {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();

        return apiInterfaceInfoMapper.selectApiInterfaceInfoById(id, userId);
    }

    /**
     * 查询接口信息列表
     *
     * @param apiInterfaceInfo 接口信息
     * @return 接口信息
     */
    @Override
    public List<ApiInterfaceInfo> selectApiInterfaceInfoList(ApiInterfaceInfo apiInterfaceInfo) {
        // 获取当前用户ID
        apiInterfaceInfo.setUserId(SecurityUtils.getUserId());

        return apiInterfaceInfoMapper.selectApiInterfaceInfoList(apiInterfaceInfo);
    }

    /**
     * 新增接口信息
     *
     * @param apiInterfaceInfo 接口信息
     * @return 结果
     */
    @Override
    public int insertApiInterfaceInfo(ApiInterfaceInfo apiInterfaceInfo) {
        // 获取当前用户ID
        apiInterfaceInfo.setUserId(SecurityUtils.getUserId());

        apiInterfaceInfo.setCreateTime(DateUtils.getNowDate());
        return apiInterfaceInfoMapper.insertApiInterfaceInfo(apiInterfaceInfo);
    }

    /**
     * 修改接口信息
     *
     * @param apiInterfaceInfo 接口信息
     * @return 结果
     */
    @Override
    public int updateApiInterfaceInfo(ApiInterfaceInfo apiInterfaceInfo) {
        // 获取当前用户ID
        apiInterfaceInfo.setUserId(SecurityUtils.getUserId());

        apiInterfaceInfo.setUpdateTime(DateUtils.getNowDate());
        return apiInterfaceInfoMapper.updateApiInterfaceInfo(apiInterfaceInfo);
    }

    /**
     * 批量删除接口信息
     *
     * @param ids 需要删除的接口信息主键
     * @return 结果
     */
    @Override
    public int deleteApiInterfaceInfoByIds(Long[] ids) {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();

        int i = apiInterfaceInfoMapper.deleteApiInterfaceInfoByIds(ids, userId);
        if (i > 0) {
            apiUserInterfaceInfoService.deleteByInterfaceId(ids);
        }
        return i;
    }

    /**
     * 删除接口信息信息
     *
     * @param id 接口信息主键
     * @return 结果
     */
    @Override
    public int deleteApiInterfaceInfoById(Long id) {
        // 获取当前用户ID
        Long userId = SecurityUtils.getUserId();

        int i = apiInterfaceInfoMapper.deleteApiInterfaceInfoById(id, userId);

        if (i > 0) {
            apiUserInterfaceInfoService.deleteByInterfaceId(new Long[]{id});
        }

        return i;
    }
}
