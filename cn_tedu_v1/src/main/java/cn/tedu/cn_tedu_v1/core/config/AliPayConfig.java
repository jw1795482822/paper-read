package cn.tedu.cn_tedu_v1.core.config;

/**
 * 支付宝支付配置类
 * Author = bianmy
 * DATE = 2023/7/15 0:07
 */
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {
    private String appId;
    private String appPrivateKey;
    private String alipayPublicKey;
    private String notifyUrl;

}