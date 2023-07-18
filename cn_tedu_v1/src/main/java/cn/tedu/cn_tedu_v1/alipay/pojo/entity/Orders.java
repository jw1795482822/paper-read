package cn.tedu.cn_tedu_v1.alipay.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单表实体类
 * Author = bianmy
 * DATE = 2023/7/17 18:32
 */
@Data
@TableName(value = "zhipian_orders")
public class Orders implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商家订单编号
     */
    private String traceNo;
    /**
     * 商品名称
     */
    private String subject;
    /**
     * 支付状态
     */
    private Integer tradeStatus;
    /**
     * 支付宝订单编号
     */
    private String outTradeNo;
    /**
     * 交易金额
     */
    private Integer totalAmount;
    /**
     * 买家在支付宝唯一ID
     */
    private String buyerId;
    /**
     * 付款时间
     */
    private String gmtPayment;
    /**
     * 付款金额
     */
    private Integer buyerPayAmount;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 书籍ID
     */
    private Integer bookId;


}