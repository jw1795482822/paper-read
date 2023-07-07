package cn.tedu.cn_tedu_v1.userv1.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = bianmy
 * DATE = 2023/6/10 15:40
 */
@Data
public class EmailDTO implements Serializable {
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
}