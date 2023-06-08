package cn.tedu.cn_tedu_v1.userv1.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.cn_tedu_v1.userv1.mapper")
public class MybatisConfig {
}