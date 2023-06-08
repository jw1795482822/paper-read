package cn.tedu.cn_tedu_v1.userv1.pojo.dto;


import lombok.Data;

@Data
public class UserRegDTO {
    private String username;
    private String nickname;
    private String password;
    private String question;
    private String answer;
}