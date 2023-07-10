package cn.tedu.cn_tedu_v1.index.bookdeatils.pojo.vo;

import lombok.Data;

@Data
public class BookDeatilsVO {
    /**
     * ID
     * */
    private Long id;
    /**
     * 书名
     * */
    private String name;
    /**
     * 作者
     * */
    private String author;
    /**
     * 书籍封面
     * */
    private String cover;
    /**
     * 详细介绍
     */
    private String introduction;
}
