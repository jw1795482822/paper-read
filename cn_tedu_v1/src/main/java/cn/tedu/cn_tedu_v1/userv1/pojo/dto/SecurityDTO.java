package cn.tedu.cn_tedu_v1.userv1.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = bianmy
 * DATE = 2023/5/20 14:57
 * 忘记密码页面接受类
 */
@Data
public class SecurityDTO implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密保问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * 密码
     */
    private String password;
}