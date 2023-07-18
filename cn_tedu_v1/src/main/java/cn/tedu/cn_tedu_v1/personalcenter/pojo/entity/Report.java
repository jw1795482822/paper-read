package cn.tedu.cn_tedu_v1.personalcenter.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;

@Data
@TableName("zhipian_report")
public class Report {
    /**
     * 唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 举报内容
     */
    private String reportContent;
    /**
     * 上传图片
     */
    private Long imgUrl ;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 图书ID
     */
    private Long bookId;
    /**
     * 图书馆ID
     */
    private Long libraryId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

}
