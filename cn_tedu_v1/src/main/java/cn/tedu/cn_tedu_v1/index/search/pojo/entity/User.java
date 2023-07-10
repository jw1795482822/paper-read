package cn.tedu.cn_tedu_v1.index.search.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("zhipian_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String admin;
    private String gender;
    private String phoneNumber;
    private Long idNumber;
    private double account;
    private String email;
    private Date createTime;
    private Date updateTime;
    private Long userId;
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
