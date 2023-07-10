package cn.tedu.cn_tedu_v1.index.bookdeatils.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "zhipian_book")
public class BookDeatils implements Serializable {
    @TableId(type = IdType.AUTO)
    /**
     * ID
     * */
    private Long id;
    /**
     * 图书馆ID
     * */

    private Long libraryId;
    /**
     * 分类ID
     * */

    private Long categoryId;
    /**
     * 用户ID
     * */

    private Long userId;
    /**
     * 书名
     * */
    private String name;
    /**
     * 作者
     * */
    private String author;
    /**
     * 出版时间
     * */

    private LocalDateTime publishTime;
    /**
     * 出版社
     * */
    private String publisher;
    /**
     * 状态:在库,借出
     * */
    private String status;
    /**
     * 书籍封面
     * */
    private String cover;
    /**
     * 库存数量
     * */

    private String storeAmount;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 详细介绍
     */
    private String introduction;
    /**
     * 借阅量
     * */

    private Integer borrowingVolume;

    /**
     * 创建时间
     * */

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     * */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


}
