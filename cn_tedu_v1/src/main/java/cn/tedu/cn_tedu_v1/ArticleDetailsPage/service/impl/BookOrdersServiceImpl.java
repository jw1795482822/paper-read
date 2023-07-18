package cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookOrdersRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IBookOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookOrdersServiceImpl implements IBookOrdersService {
    @Autowired
    private IBookOrdersRepository ordersRepository;

    public BookOrdersServiceImpl() {
        log.warn("开始执行：IOrdersService");
    }

    @Override
    public Integer SelectBytRadeStatus(Integer userId, Integer bookID) {
        log.warn("开始执行【查找权限】的数据访问，参数：用户id{}，书籍id{}",userId,bookID);
        return ordersRepository.SelectBytRadeStatus(userId,bookID);
    }
}
