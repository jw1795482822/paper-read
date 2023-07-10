package cn.tedu.cn_tedu_v1.index.search.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("zhipian_libray")
public class Library {

    /**
     唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 图书馆名称
     */
    private String name;
    /**
     * 图书馆地址
     */
    private String address;
    /**
     * 借阅规则
     */
    private String rule;
    /**
     * 图书馆访问数量
     */
    private Integer clickNum;
    /**
     * 开始时间
     * */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    /**
     * 修改时间
     * */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
