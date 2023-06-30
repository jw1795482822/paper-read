package cn.tedu.cn_tedu_v1.userv1.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * 用户登录结果的VO类
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Data
@Accessors(chain = true)
public class UserLoginResultVO implements Serializable {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 权限
     */
    private Collection<GrantedAuthority> admin;

    /**
     * Token（JWT）
     */
    private String token;

}
