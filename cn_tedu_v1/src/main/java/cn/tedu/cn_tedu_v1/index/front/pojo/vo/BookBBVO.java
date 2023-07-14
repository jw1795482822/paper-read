package cn.tedu.cn_tedu_v1.index.front.pojo.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = lee
 * DATE   = 2023/7/14  16:47
 */

@Data
@TableName(value = "zhipian_book")
public class BookBBVO implements Serializable {
    @TableId(type = IdType.AUTO)
    /**
     * ID
     * */
    private Long Id;
    /**
     * 用户ID
     */

    private Long userId;
    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
    /**
     * 书籍封面
     */
    private String cover;
    /**
     * 库存数量
     */

    private String storeAmount;
    /**
     * 借阅量
     */
    private Integer borrowingVolume;
   /* *//**
     * 创建时间
     *//*
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    *//**
     * 修改时间
     *//*
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;*/


}


