package cn.tedu.cn_tedu_v1.userv1.redis;

/**
 * 向redis中存储验证码
 * Author = bianmy
 * DATE = 2023/7/7 15:37
 */
public interface IRedisCode {
    /**
     * 向redis中存入邮箱验证码
     */
    void saveEmailCode(String emailCode,Integer code);

    /**
     * 从redis中取出验证码
     * @param emailCode 邮箱
     * @return
     */
    Integer getEmailCode(String emailCode);
}