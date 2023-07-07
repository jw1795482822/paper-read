package cn.tedu.cn_tedu_v1.userv1.pojo.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;

/**
 * 获取登录信息的类
 */
@Data
public class UserVO  implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String admin;
}