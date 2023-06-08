package cn.tedu.cn_tedu_v1.userv1.pojo.vo;

import lombok.Data;

/**
 * 获取登录信息的类
 */
@Data
public class UserVO {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String admin;
}