package cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "zhipian_date")
public class Date implements Serializable {
    @TableId(type = IdType.AUTO)
    /**
     * 唯一标识
     * */
    private Long id;
    /**
     * PDF文件URL
     */
    private String pdfUrl;
    /**
     * 关联图书主键
     */
    private Long bookId;
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
