package cn.tedu.cn_tedu_v1.personalcenter.pojo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 密保问题实体类
 * Author = bianmy
 * DATE = 2023/5/19 21:35
 */

@Data
public class Security implements Serializable {
    /**
     * 主键ID
    * */
    private Long id;
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
}