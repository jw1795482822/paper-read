package cn.tedu.cn_tedu_v1.userv1.pojo.dto;


import lombok.Data;

@Data
public class UserRegDTO {
    private String email;
    private String username;
    private String nickname;
    private String password;
    private String question;
    private String answer;
    //用于接受前端传来验证码
    private String code;
}