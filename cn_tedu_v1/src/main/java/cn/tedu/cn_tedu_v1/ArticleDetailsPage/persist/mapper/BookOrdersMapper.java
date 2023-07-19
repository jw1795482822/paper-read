package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

//支付订单表
@Repository
public interface BookOrdersMapper extends BaseMapper<BookOrders> {
//查询是否拥有此书
    Integer SelectBytRadeStatus(Integer userId,Integer bookID);

}
