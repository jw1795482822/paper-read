package cn.tedu.cn_tedu_v1.index.front.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = lee
 * DATE   = 2023/7/19  21:31
 */
@Data
@TableName("zhipian_bookpage")
public class BookPage implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long bookId;
    private Long bookPage;
    private Long totalPage;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


}
