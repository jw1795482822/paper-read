package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.userv1.redis.IRedisCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = bianmy
 * DATE = 2023/7/7 15:56
 */
@SpringBootTest
public class RedisTests {
    @Autowired
    IRedisCode redisCode;

    @Test
    void xxx() {
        String email = "aqa";
        Integer code = 1234;
        redisCode.saveEmailCode(email,code);
    }
}
