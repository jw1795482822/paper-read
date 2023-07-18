package cn.tedu.cn_tedu_v1.personalcenter.pojo.vo;

import lombok.Data;

@Data
public class SecurityPersonalVO {
    /**
     * 问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * 与用户表关联的ID
     * */
    private Long userId;
    /**
     * 密码
     */
    private String password;

}
