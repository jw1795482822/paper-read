package cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "zhipian_category")
public class BookCategory implements Serializable {
    @TableId(type = IdType.AUTO)
    /**
     * ID
     * */
    private Long id;
    /**
     * 类别名称
     * */
    private String name;
    /**
     * 父级类别ID，如果无父级，则为0
     */
    private Long parentId;
    /**
     * 深度，最顶级类别的深度为1，次级为2，以此类推
     */
    private Integer depth;
    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;
    /**
     * 排序序号
     */
    private Integer sort;
    /**
     * 图标图片的URL
     */
    private String icon;
    /**
     * 是否为父级（是否包含子级），1=是父级，0=不是父级
     */
    private Integer isParent;

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
