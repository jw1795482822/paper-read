package cn.tedu.cn_tedu_v1.userv1.pojo.entiy;


import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String question;
    private String admin;
}