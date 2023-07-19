package cn.tedu.cn_tedu_v1.alipay.dao.mapper;

import cn.tedu.cn_tedu_v1.alipay.pojo.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * Author = bianmy
 * DATE = 2023/7/17 18:42
 */
public interface OrdersMapper extends BaseMapper<Orders> {

    /**
     * 根据用户ID查询支付成功的订单数量
     * @return 订单数量
     */
    int selectByUserId(Integer userId);

}