package cn.tedu.cn_tedu_v1.alipay;

/**
 *
 * Author = bianmy
 * DATE = 2023/7/15 0:09
 */
import lombok.Data;

@Data
public class AliPay {
    private String traceNo;
    private double totalAmount;
    private String subject;
    private String alipayTraceNo;
}