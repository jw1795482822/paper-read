package cn.tedu.cn_tedu_v1.alipay.pojo.entity;

/**
 *
 * Author = bianmy
 * DATE = 2023/7/15 0:09
 */
import lombok.Data;

import java.io.Serializable;

@Data
public class AliPay implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 图书ID
     */
    private Integer bookId;
    /**
     * 订单号
     */
    private String traceNo;
    /**
     * 金额
     */
    private double totalAmount;
    /**
     * 商品名称
     */
    private String subject;

    private String alipayTraceNo;
}