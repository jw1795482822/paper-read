package cn.tedu.cn_tedu_v1.userv1.redis.impl;

import cn.tedu.cn_tedu_v1.userv1.redis.IRedisCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * 向redis中存储验证码
 * Author = bianmy
 * DATE = 2023/7/7 15:38
 */
@Configuration
@Slf4j
public class RedisCodeImpl implements IRedisCode {


    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;
    @Override
    public void saveEmailCode(String emailCode,Integer code) {
        log.debug("传入邮箱验证码:{},存储两分中",code);
        redisTemplate.opsForValue().set(emailCode, code, 2, TimeUnit.MINUTES);
    }

    @Override
    public Integer getEmailCode(String emailCode) {

       return (Integer) redisTemplate.opsForValue().get(emailCode);

    }
}