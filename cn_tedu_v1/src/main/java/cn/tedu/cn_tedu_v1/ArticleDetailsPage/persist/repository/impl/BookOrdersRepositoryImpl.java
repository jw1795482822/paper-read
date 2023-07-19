package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.BookOrdersMapper;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookOrdersRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookOrders;
import cn.tedu.cn_tedu_v1.favorites.pojo.entity.Favorites;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BookOrdersRepositoryImpl implements IBookOrdersRepository {
    @Autowired
    private BookOrdersMapper ordersMapper;

    public BookOrdersRepositoryImpl() {
        log.warn("开始执行：IOrdersRepository");
    }

    @Override
    public Integer SelectBytRadeStatus(Integer userId, Integer bookID) {
        log.warn("开始执行【查找权限】的数据访问，参数：用户id{}，书籍id{}",userId,bookID);
        QueryWrapper<BookOrders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("book_ID",bookID);
        queryWrapper.eq("trade_status",0);
        return ordersMapper.selectCount(queryWrapper);
    }
}
