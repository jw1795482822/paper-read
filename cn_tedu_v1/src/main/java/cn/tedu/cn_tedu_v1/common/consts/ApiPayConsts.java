package cn.tedu.cn_tedu_v1.common.consts;

/**
 * 支付宝支付相关常量
 *
 * @author 边明扬
 */
public interface ApiPayConsts {
    String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    String FORMAT = "JSON";
    String CHARSET = "UTF-8";
    //签名方式
    String SIGN_TYPE = "RSA2";
}
