package com.xiaofei.utils.service;

import com.xiaofei.utils.entity.RegionEntity;

import java.util.List;

/**
 * User: XiaoFei
 * Date: 2023-03-06
 * Time: 16:07:47.152
 * Email: 1903078434@qq.com
 *
 * @author XiaoFei
 */
public interface RegionService {

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return 指定条件数据
     */
    RegionEntity selectById(Long id);

    /**
     * 根据传递的参数查询单条数据
     *
     * @param regionEntity 查询参数
     * @return 指定条件的数据
     */
    RegionEntity selectOne(RegionEntity regionEntity);

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    List<RegionEntity> selectList();

    /**
     * 查询全部，结果为树形结构
     *
     * @return 全部数据，树形结构
     */
    List<RegionEntity> selectListTree();

    /**
     * 根据条件查询
     *
     * @param regionEntity 查询参数
     * @return 满足条件的信息
     */
    List<RegionEntity> listBySearch(RegionEntity regionEntity);
}
