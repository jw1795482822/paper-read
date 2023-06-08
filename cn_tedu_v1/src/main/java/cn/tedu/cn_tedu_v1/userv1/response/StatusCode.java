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
//    PASSWORD_ERROR_TWICE(1001, "用户账号或密码错误,还有2次机会!"),
//    PASSWORD_ERROR_ONCE(1002, "用户账号或密码错误,还有1次机会!"),
//    PASSWORD_ERROR(1003, "用户账号或密码错误,当天无机会,请采用密保验证!"),
    PASSWORD_ERROR(1003, "密码错误!"),
    QUESTION_ERROR_TWICE(1004, "密保答案填写错误,请重新填写,还有2次机会!"),
    QUESTION_ERROR_ONCE(1005, "密保答案填写错误,请重新填写,还有1次机会!"),
    QUESTION_ERROR(1006, "密保验证次数以达到今日上线,请明天尝试登录!"),
    REPEAT_USER(1007, "您当用户名已存在,请重新注册!"),
    FORBIDDEN_ERROR(1008,"无权访问");

    private int code;
    private String misDescription;

    StatusCode(){}

    StatusCode(int code, String description) {
        this.code = code;
        this.misDescription = description;
    }


}