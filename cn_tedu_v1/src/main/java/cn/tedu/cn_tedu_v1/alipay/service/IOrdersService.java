package cn.tedu.cn_tedu_v1.alipay.service;

import cn.tedu.cn_tedu_v1.alipay.pojo.entity.AliPay;
import cn.tedu.cn_tedu_v1.alipay.pojo.entity.Orders;
import com.alipay.api.AlipayApiException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 支付宝支付业务层
 * Author = bianmy
 * DATE = 2023/7/17 20:29
 */
public interface IOrdersService {

    /**
     * 根据传来的参数，插入订单表
     * @param aliPay
     * @param httpResponse
     * @throws IOException
     */
    void pay(AliPay aliPay, HttpServletResponse httpResponse) throws IOException;

    /**
     * 根据回调接口传来的参数修改订单信息
     */
    int payNotify(HttpServletRequest request) throws AlipayApiException;

    /**
     * 根据用户ID查找支付成功订单
     */
    int selectByUserId(Integer userId);
}