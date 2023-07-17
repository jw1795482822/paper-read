package cn.tedu.cn_tedu_v1.personalcenter.pojo.param;

import lombok.Data;

/**
 * wsk
 * 修改密码
 */
@Data
public class UserPersonalParam {
    /**
     * 密码
     */
    private String password;
    /**
     * 问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * 用户Id
     */
    private Long userID;

    /**
     * 密码
     */
    private String passwordJ;
}
