package cn.tedu.cn_tedu_v1.alipay.service.impl;

import cn.hutool.json.JSONObject;
import cn.tedu.cn_tedu_v1.alipay.dao.repository.IOrdersRepository;
import cn.tedu.cn_tedu_v1.alipay.pojo.entity.AliPay;
import cn.tedu.cn_tedu_v1.alipay.pojo.entity.Orders;
import cn.tedu.cn_tedu_v1.alipay.service.IOrdersService;
import cn.tedu.cn_tedu_v1.common.consts.ApiPayConsts;
import cn.tedu.cn_tedu_v1.core.config.AliPayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author = bianmy
 * DATE = 2023/7/17 20:31
 */
@Repository
@Slf4j
public class OrdersServiceImpl implements IOrdersService, ApiPayConsts {

    @Autowired
    private IOrdersRepository ordersRepository;

    @Resource
    private AliPayConfig aliPayConfig;

    public OrdersServiceImpl() {
        log.info("支付宝订单service层启动");
    }

    /**
     * 支付宝回传页面方法
     *
     * @param aliPay       &subject=xxx&traceNo=xxx&totalAmount=xxx
     * @param httpResponse
     */
    @Override
    public void pay(AliPay aliPay, HttpServletResponse httpResponse) throws IOException {


        // 1. 创建Client，通用SDK提供的Client，负责调用支付宝的API
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(), FORMAT, CHARSET, aliPayConfig.getAlipayPublicKey(), SIGN_TYPE);

        // 2. 创建 Request并设置Request参数
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();  // 发送请求的 Request类
        request.setNotifyUrl(aliPayConfig.getNotifyUrl());
        JSONObject bizContent = new JSONObject();
        bizContent.set("out_trade_no", aliPay.getTraceNo());  // 我们自己生成的订单编号
        bizContent.set("total_amount", aliPay.getTotalAmount()); // 订单的总金额
        bizContent.set("subject", aliPay.getSubject());   // 支付的名称
        bizContent.set("product_code", "FAST_INSTANT_TRADE_PAY");  // 固定配置
        request.setBizContent(bizContent.toString());

        //订单信息插入表中
        Orders orders = new Orders();
        BeanUtils.copyProperties(aliPay, orders);
        double totalAmount=Double.valueOf(aliPay.getTotalAmount());
        orders.setTotalAmount((int) (totalAmount * 100));//金额单位为分
        orders.setTradeStatus(1);//未支付
        ordersRepository.insert(orders);


        // 执行请求，拿到响应的结果，返回给浏览器
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    /**
     * 根据回调接口传来的参数修改订单信息
     *
     * @param request
     */
    @Override
    public int payNotify(HttpServletRequest request) throws AlipayApiException {
        log.info("支付回调请求处理");
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }

            String outTradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");

            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, aliPayConfig.getAlipayPublicKey(), "UTF-8"); // 验证签名
            // 支付宝验签
            if (checkSignature) {
                // 验签通过
                log.info("交易名称:{} ", params.get("subject"));
                log.info("交易状态:{} " , params.get("trade_status"));
                log.info("支付宝交易凭证号:{} " , params.get("trade_no"));
                log.info("商户订单号: {}" , params.get("out_trade_no"));
                log.info("交易金额: {}" , params.get("total_amount"));
                log.info("买家在支付宝唯一id:{} " , params.get("buyer_id"));
                log.info("买家付款时间: {}" , params.get("gmt_payment"));
                log.info("买家付款金额: {}" , params.get("buyer_pay_amount"));

                //修改订单信息
                Orders orders = new Orders();
                orders.setTradeStatus(2);//已支付
                orders.setOutTradeNo(params.get("trade_no"));
                orders.setBuyerId(params.get("buyer_id"));
                orders.setGmtPayment(params.get("gmt_payment"));
                double payAmount = Double.valueOf(params.get("buyer_pay_amount"));
                orders.setBuyerPayAmount((int)(payAmount*100));
                log.info("修改订单信息实体类参数：{}",orders);

                QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("trace_no",params.get("out_trade_no"));
                return ordersRepository.update(orders,queryWrapper);

            }
        }
        return 0;//修改失败，未支付

    }

    /**
     * 根据用户ID查找支付成功订单
     * @param userId 用户ID
     * @return
     */
    @Override
    public int selectByUserId(Integer userId) {
        return ordersRepository.selectByUserId(userId);
    }


}