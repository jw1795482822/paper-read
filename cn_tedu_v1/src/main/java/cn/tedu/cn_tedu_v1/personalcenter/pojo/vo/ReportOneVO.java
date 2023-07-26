package cn.tedu.cn_tedu_v1.personalcenter.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Data
@Transactional
public class ReportOneVO {

    /**
     * 图书馆ID
     */
    private Long bookId;
    /**
     * 图书馆ID
     */
    private Long userId;
    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
