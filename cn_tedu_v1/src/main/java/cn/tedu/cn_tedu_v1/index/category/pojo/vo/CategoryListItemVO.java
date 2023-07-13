package cn.tedu.cn_tedu_v1.index.category.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = sun
 * DATE = 2023/7/13 20:25
 */
@Data
public class CategoryListItemVO implements Serializable {
    /**
     * 数据ID
     */
    private Long id;
    /**
     * 类别名称
     */
    private String name;
}
