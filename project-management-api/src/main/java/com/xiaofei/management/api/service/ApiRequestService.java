package com.xiaofei.management.api.service;

import com.xiaofei.management.api.dto.ApiInterfaceRequestDTO;

/**
 * ClassName: ApiRequestController
 * Package: com.xiaofei.management.api.service
 *
 * @Author: XiaoFei
 * @Create: 2024/2/27 22:08
 * @Email: 1903078434@qq.com
 * @Version: 1.0
 */
public interface ApiRequestService {

    /**
     * 前端测试调用
     */
    String testRequest(ApiInterfaceRequestDTO apiInterfaceRequestDTO);

    /**
     * 国家地区查询【根据传递的参数进行分页查询】
     */
    String regionListByPage(String accessKey, String encryptData);

    /**
     * 根据id查询
     *
     * @return 指定条件数据
     */
    String selectRegionById(String accessKey, String encryptData);

    /**
     * 根据传递的参数查询单条数据
     *
     * @return 指定条件的数据
     */
    String selectRegionOne(String accessKey, String encryptData);

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    String selectRegionList(String accessKey);

    /**
     * 查询全部，结果为树形结构
     *
     * @return 全部数据，树形结构
     */
    String selectRegionListTree(String accessKey);


    /**
     * 根据条件查询
     *
     * @return 满足条件的信息
     */
    String listRegionBySearch(String accessKey, String encryptData);
}
