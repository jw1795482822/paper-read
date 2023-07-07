package cn.tedu.cn_tedu_v1.userv1.pojo.dto;


import lombok.Data;

import java.io.Serializable;

/*
* 注册和登录通用的接受前端数据类
* */
@Data
public class UserRegDTO  implements Serializable {
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 密保问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * 用于接受前端传来验证码
     */
    private String code;
}