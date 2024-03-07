package com.xiaofei.management.api.service.impl;

import com.xiaofei.management.api.domain.ApiInterfaceRequestInfo;
import com.xiaofei.management.api.mapper.ApiInterfaceRequestInfoMapper;
import com.xiaofei.management.api.service.IApiInterfaceRequestInfoService;
import com.xiaofei.management.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口请求记录Service业务层处理
 *
 * @author xiaofei
 * @date 2024-03-07
 */
@Service
@Transactional
public class ApiInterfaceRequestInfoServiceImpl implements IApiInterfaceRequestInfoService {
    @Autowired
    private ApiInterfaceRequestInfoMapper apiInterfaceRequestInfoMapper;

    /**
     * 查询接口请求记录
     *
     * @param id 接口请求记录主键
     * @return 接口请求记录
     */
    @Override
    public ApiInterfaceRequestInfo selectApiInterfaceRequestInfoById(Long id) {
        return apiInterfaceRequestInfoMapper.selectApiInterfaceRequestInfoById(id);
    }

    /**
     * 查询接口请求记录列表
     *
     * @param apiInterfaceRequestInfo 接口请求记录
     * @return 接口请求记录
     */
    @Override
    public List<ApiInterfaceRequestInfo> selectApiInterfaceRequestInfoList(ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        return apiInterfaceRequestInfoMapper.selectApiInterfaceRequestInfoList(apiInterfaceRequestInfo);
    }

    /**
     * 新增接口请求记录
     *
     * @param apiInterfaceRequestInfo 接口请求记录
     * @return 结果
     */
    @Override
    public int insertApiInterfaceRequestInfo(ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        apiInterfaceRequestInfo.setCreateTime(DateUtils.getNowDate());
        return apiInterfaceRequestInfoMapper.insertApiInterfaceRequestInfo(apiInterfaceRequestInfo);
    }

    /**
     * 修改接口请求记录
     *
     * @param apiInterfaceRequestInfo 接口请求记录
     * @return 结果
     */
    @Override
    public int updateApiInterfaceRequestInfo(ApiInterfaceRequestInfo apiInterfaceRequestInfo) {
        return apiInterfaceRequestInfoMapper.updateApiInterfaceRequestInfo(apiInterfaceRequestInfo);
    }

    /**
     * 批量删除接口请求记录
     *
     * @param ids 需要删除的接口请求记录主键
     * @return 结果
     */
    @Override
    public int deleteApiInterfaceRequestInfoByIds(Long[] ids) {
        return apiInterfaceRequestInfoMapper.deleteApiInterfaceRequestInfoByIds(ids);
    }

    /**
     * 删除接口请求记录信息
     *
     * @param id 接口请求记录主键
     * @return 结果
     */
    @Override
    public int deleteApiInterfaceRequestInfoById(Long id) {
        return apiInterfaceRequestInfoMapper.deleteApiInterfaceRequestInfoById(id);
    }

    /**
     * 定时生成最近指定天数调用接口次数数据
     */
    public void generateRequestInfo(Integer loopCount, Integer recentDays) {
        apiInterfaceRequestInfoMapper.generateRequestInfo(loopCount, recentDays);
    }

    /**
     * 统计查询
     */
    @Override
    public Map<String, Object> statisticalQuery() {
        Map<String, Object> respData = new HashMap<>();
        List<Map<String, String>> countRequestByDate = apiInterfaceRequestInfoMapper.countRequestByDate();
        List<Map<String, String>> userRequestCount = apiInterfaceRequestInfoMapper.userRequestCount();
        List<Map<String, String>> countInterfaceRequest = apiInterfaceRequestInfoMapper.countInterfaceRequest();
        respData.put("countRequestByDate", countRequestByDate);
        respData.put("userRequestCount", userRequestCount);
        respData.put("countInterfaceRequest", countInterfaceRequest);
        return respData;
    }
}
