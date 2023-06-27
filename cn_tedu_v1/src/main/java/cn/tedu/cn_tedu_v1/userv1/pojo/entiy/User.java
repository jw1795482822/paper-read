package cn.tedu.cn_tedu_v1.userv1.pojo.entiy;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class User {
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
}