package cn.tedu.cn_tedu_v1.index.front.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = lee
 * DATE   = 2023/7/9  20:58
 */
@Data
public class CategoryVO implements Serializable {
    private Long id;
    private String name;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 轮播图标题
     */
    private String title;

}
