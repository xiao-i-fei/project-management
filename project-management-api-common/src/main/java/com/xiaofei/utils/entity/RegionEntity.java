package com.xiaofei.utils.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 国家地区信息
 *
 * User: XiaoFei
 * Date: 2023-03-06
 * Time: 16:07:47.152
 * Email: 1903078434@qq.com
 *
 * @author XiaoFei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RegionEntity extends BaseEntity implements Serializable {

    private Long id;

    private Long parentId;

    private Byte deep;

    private String regionName;

    private String pinyinPrefix;

    private String pinyin;

    private String extId;

    private String extName;

    /**
     * 将当前菜单的所有子分类都放到这个children属性里面
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)//如果该属性的值为空，将不会带上该值
    private List<RegionEntity> children;

    private static final long serialVersionUID = 1L;
}
