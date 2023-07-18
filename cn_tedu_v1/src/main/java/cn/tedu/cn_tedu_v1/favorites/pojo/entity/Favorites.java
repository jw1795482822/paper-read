package cn.tedu.cn_tedu_v1.favorites.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 收藏夹实体类
 * Author = bianmy
 * DATE = 2023/7/18 17:49
 */
@Data
@TableName("zhipian_favorites")
public class Favorites implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 图书ID
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