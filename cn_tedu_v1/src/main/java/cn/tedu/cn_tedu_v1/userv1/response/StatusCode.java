package cn.tedu.cn_tedu_v1.userv1.response;
import lombok.Getter;
/**
 * Author = bianmy
 * DATE = 2023/5/19 23:16
 * 错误编码表
 */
@Getter
public enum StatusCode {
    SUCCESS(1000, "成功"),
    ERROR(8888,"异常错误"),
    NOT_LOGIN(7777, "用户未登录!"),

    PASSWORD_ERROR(1003, "密码错误!"),
    QUESTION_ERROR_TWICE(1004, "密保答案填写错误,请重新填写,还有2次机会!"),
    QUESTION_ERROR_ONCE(1005, "密保答案填写错误,请重新填写,还有1次机会!"),
    QUESTION_ERROR(1006, "密保验证次数以达到今日上线,请明天尝试登录!"),
    REPEAT_USER(1007, "您当用户名已存在,请重新注册!"),
    FORBIDDEN_ERROR(1008,"无权访问"),
    USER_NOT_EXIST_ERROR(1009,"用户不存在"),
    VERIFICATION_ERROR(1010, "验证码错误,请重新输入"),
    EMAIL_EXISTS_ERROR(1011, "电子邮箱账户存在,请重新输入"),
    SEND_ERROR(1012, "验证码发送失败"),
    ERROR_UNAUTHORIZED(4010,"操作失败,当前未登录"),
    NOT_EMAIL_ERROR(1013, "邮箱不存在");


    private int code;
    private String msg;

    StatusCode(){}

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}