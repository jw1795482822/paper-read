package cn.tedu.cn_tedu_v1.index.search.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("zhipian_book")
public class Book {
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
