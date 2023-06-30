package cn.tedu.cn_tedu_v1.userv1.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author = bianmy
 * DATE = 2023/6/10 15:40
 */
@Data
public class EmailDTO implements Serializable {
    private String email;
    private String password;
    private String code;
}