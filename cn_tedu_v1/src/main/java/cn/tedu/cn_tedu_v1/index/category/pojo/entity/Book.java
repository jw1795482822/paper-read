package cn.tedu.cn_tedu_v1.index.category.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = sun
 * DATE = 2023/7/14 16:07
 */
@Data
@TableName("zhipian_book")
public class Book implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long libraryId;
    private Long categoryId;
    private Long userId;
    private String name;
    private String author;
    private LocalDateTime publishTime;
    private String publisher;
    private String status;
    private String cover;
    private String storeAmount;
    private Integer sort;
    private String introduction;
    private Integer borrowingVolume;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
