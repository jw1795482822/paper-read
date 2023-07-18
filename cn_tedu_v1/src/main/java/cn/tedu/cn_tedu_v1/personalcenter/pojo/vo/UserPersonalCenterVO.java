package cn.tedu.cn_tedu_v1.personalcenter.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * wsk
 * 查看个人信息
 */
@Data
public class UserPersonalCenterVO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 身份证号码
     */
    private Long idNumber;
    /**
     * 账户余额
     */
    private double account;
    /**
     * 邮箱
     */
    private String email;
}
