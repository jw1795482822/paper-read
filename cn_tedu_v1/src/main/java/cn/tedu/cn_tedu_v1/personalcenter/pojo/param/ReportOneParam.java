package cn.tedu.cn_tedu_v1.personalcenter.pojo.param;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReportOneParam {
    /**
     * 举报内容
     */
    private String reportContent;
    /**
     * 图书ID
     */
    private Long bookId;
    /**
     * 图书馆ID
     */
    private Long libraryId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
