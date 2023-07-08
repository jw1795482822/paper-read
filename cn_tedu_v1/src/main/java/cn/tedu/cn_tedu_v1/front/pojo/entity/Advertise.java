package cn.tedu.cn_tedu_v1.front.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("zhipian_advertisement")
public class Advertise implements Serializable {

    private Long id;
    private String name;
    private String url;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

}
