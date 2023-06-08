package cn.tedu.cn_tedu_v1.userv1.pojo.dto;

import lombok.Data;

/**
 * Author = bianmy
 * DATE = 2023/5/20 14:57
 * 忘记密码页面接受类
 */
@Data
public class SecurityDTO {
    private String username;
    private String question;
    private String answer;
    private String password;
}