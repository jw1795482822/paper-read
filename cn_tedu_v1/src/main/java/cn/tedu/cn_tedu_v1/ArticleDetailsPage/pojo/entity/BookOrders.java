package cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName(value = "zhipian_orders")
public class BookOrders implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     *买家订单编号
     */
    private String traceNo;
    /**
     *商品名称
     */
    private String subject;
    /**
     *订单状态 0已支付 1未支付 2支付中
     */
    private Integer tradeStatus;
    /**
     *支付宝订单号
     */
    private String outTradeNo;
    /**
     *交易金额
     */
    private Integer totalAmount;
    /**
     *买家在支付宝唯一ID
     */
    private String buyerId;
    /**
     *付款时间
     */
    private String gmtPayment;
    /**
     *卖家付款金额
     */
    private Integer buyerPayAmount;
    /**
     *用户ID
     */
    private Integer userId;
    /**
     *购买书籍ID
     */
    private Integer  bookID;
}
