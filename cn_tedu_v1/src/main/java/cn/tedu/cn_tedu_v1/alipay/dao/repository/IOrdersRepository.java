package cn.tedu.cn_tedu_v1.alipay.dao.repository;

import cn.tedu.cn_tedu_v1.alipay.pojo.entity.Orders;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.sql.Wrapper;

/**
 * Author = bianmy
 * DATE = 2023/7/17 19:02
 */
public interface IOrdersRepository {
    /**
     * 用户发起付款插入数据
     * @param orders 订单实体类
     * @return 插入数量
     */
    int insert(Orders orders);

    /**
     * 根据返回订单状态修改订单信息
     */
    int update(Orders orders, QueryWrapper<Orders> queryWrapper);
}