package cn.tedu.cn_tedu_v1.alipay.controller;

/**
 * 支付宝支付业务类
 * Author = bianmy
 * DATE = 2023/7/15 0:10
 */
import cn.hutool.json.JSONObject;
import cn.tedu.cn_tedu_v1.alipay.pojo.entity.AliPay;
import cn.tedu.cn_tedu_v1.alipay.service.IOrdersService;
import cn.tedu.cn_tedu_v1.common.consts.ApiPayConsts;
import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import cn.tedu.cn_tedu_v1.core.config.AliPayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

// xjlugv6874@sandbox.com
// 9428521.24 - 30 = 9428491.24 + 30 = 9428521.24
@RestController
@RequestMapping("/alipay")
@Slf4j
public class AliPayController implements ApiPayConsts {

    @Autowired
    private IOrdersService ordersService;

    /**
     * 处理支付宝支付请求
     * @param aliPay
     * @param httpResponse
     * @throws Exception
     */
    @GetMapping("/pay") // &subject=xxx&traceNo=xxx&totalAmount=xxx
    public void pay(AliPay aliPay, HttpServletResponse httpResponse) throws Exception {
        log.info("支付宝controller接受请求参数:{}", aliPay);
        ordersService.pay(aliPay, httpResponse);
    }

    /**
     * 处理支付宝回调请求
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/notify")  // 注意这里必须是POST接口
    public JsonResult payNotify(HttpServletRequest request) throws Exception {
        log.info("支付宝controller接受请求参数:{}", request);
        if(ordersService.payNotify(request) == 1){
            return JsonResult.ok();
        }
        String message = "订单未支付或支付异常，请重新支付！";
        return JsonResult.fail(ServiceCode.ERROR_NOT_PAY,message);

    }

    @PostMapping("/{id}/status")
    public JsonResult selectByUserId(@PathVariable("id") Integer userId) {
        return JsonResult.ok(ordersService.selectByUserId(userId));
    }
}