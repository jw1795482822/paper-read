package cn.tedu.cn_tedu_v1.index.front.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author = lee
 * DATE   = 2023/7/9  20:53
 */
@Data
public class Category implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    /**
     * 父级类别ID，如果无父级，则为0
     */
    private Long parent_id;
    /**
     * 深度，最顶级类别的深度为1，次级为2，以此类推
     */
    private Integer depth;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 排序序号
     */
    private Integer sort;
    private String icon;
    /**
     * 是否启用，1=启用，0=未启用
     */
    private Boolean enable;
    /**
     * 是否为父级（是否包含子级），1=是父级，0=不是父级
     */
    private Boolean is_parent;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

}
