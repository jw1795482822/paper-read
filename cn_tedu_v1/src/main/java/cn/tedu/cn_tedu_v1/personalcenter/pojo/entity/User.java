package cn.tedu.cn_tedu_v1.personalcenter.pojo.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户表实体类
 */
@Data
@TableName("zhipian_user")
public class User implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String user_name;
    /**
     * 昵称
     */
    private String nick_name;
    /**
     * 密码
     */
    private String password;
    /**
     * 权限:uesr--用户  admin--系统管理员
     * bookadmin--图书馆管理员
     */
    private String admin;
    /**
     * 性别
     */
    private String gender;
    /**
     * 手机号
     */
    private String phone_number;
    /**
     * 省份证号码
     */
    private Long id_number;
    /**
     * 账户余额
     */
    private double account;
    /**
     * 邮箱
     */
    private String e_mail;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 用于存储雪花算法生成唯一标识,暂时用到
     */
    private Long user_id;
    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}