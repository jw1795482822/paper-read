package cn.tedu.cn_tedu_v1.alipay.dao.repository.impl;

import cn.tedu.cn_tedu_v1.alipay.dao.mapper.OrdersMapper;
import cn.tedu.cn_tedu_v1.alipay.dao.repository.IOrdersRepository;
import cn.tedu.cn_tedu_v1.alipay.pojo.entity.Orders;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Wrapper;

/**
 * 订单Repository实现类
 * Author = bianmy
 * DATE = 2023/7/17 19:04
 */
@Slf4j
@Repository
public class OrdersRepositoryImpl implements IOrdersRepository {

    public OrdersRepositoryImpl() {
        log.info("支付宝订单Repository层启动");
    }

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 用户发起付款插入数据
     * @param orders 订单实体类
     * @return 插入数量
     */
    @Override
    public int insert(Orders orders) {

        return ordersMapper.insert(orders);
    }

    /**
     * 根据返回订单状态修改订单信息
     */
    @Override
    public int update(Orders orders, QueryWrapper<Orders> queryWrapper) {
        return ordersMapper.update(orders, queryWrapper);
    }

    /**
     * 根据用户ID查找支付成功订单
     * @param userId 用户ID
     * @return
     */
    @Override
    public int selectByUserId(Integer userId) {
        return ordersMapper.selectByUserId(userId);
    }
}