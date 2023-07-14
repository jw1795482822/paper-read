package cn.tedu.cn_tedu_v1.index.zhangxin.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@TableName(value = "zhipian_banner")
public class Banner implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String imgUrl;
    private Integer sort;
    private String title;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     * */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}

