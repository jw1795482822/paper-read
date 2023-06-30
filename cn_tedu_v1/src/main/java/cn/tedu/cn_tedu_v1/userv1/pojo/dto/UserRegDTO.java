package cn.tedu.cn_tedu_v1.userv1.pojo.dto;


import lombok.Data;

import java.io.Serializable;

/*
* 注册和登录通用的接受前端数据类
* */
@Data
public class UserRegDTO  implements Serializable {
    private String email;
    private String username;
    private String nickname;
    private String password;
    private String question;
    private String answer;
    //用于接受前端传来验证码
    private String code;
}