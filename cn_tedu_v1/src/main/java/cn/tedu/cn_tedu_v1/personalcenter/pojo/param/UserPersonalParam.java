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
     * 用户输入的原密码 用作对比不存入数据库
     */
    private String passwordJ;
}
