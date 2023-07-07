package cn.tedu.cn_tedu_v1.userv1.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于邮箱忘记密码VO类,查找用户名,通过发送给用户
 * Author = bianmy
 * DATE = 2023/6/10 15:40
 */
@Data
public class EmailForGetVO implements Serializable {
    private String email;

    private String userName;
}