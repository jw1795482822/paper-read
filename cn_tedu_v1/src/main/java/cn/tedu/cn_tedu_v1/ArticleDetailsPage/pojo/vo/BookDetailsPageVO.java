package cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文章查询信息页面展示信息
 */
@Data
@Accessors(chain = true)
public class BookDetailsPageVO implements Serializable {
    /**
     * ID
     * */
    private Long id;
    /**
     * 图书馆id
     */
    private Long libraryId;
    /**
     * 书名
     * */
    private String name;
    /**
     * 作者
     * */
    private String author;
    /**
     * 借阅数量
     */
    private Integer borrowingVolume;
    /**
     * 详细介绍
     */
    private String introduction;
    /**
     * 出版社
     */
    private String publisher;
    /**
     * 书籍封面
     * */
    private String cover;
    /**
     * 出版时间
     */
    private LocalDateTime publishTime;
    /**
     * 子标签
     */
    private String CategoryName;
}
