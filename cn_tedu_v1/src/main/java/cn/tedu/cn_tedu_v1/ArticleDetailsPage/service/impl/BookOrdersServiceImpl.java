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
    //查询是否过此购买过此书(是否拥有此书)
    @Override
    public Integer SelectBytRadeStatus(Integer userId, Integer bookID) {
        log.warn("Service层开始执行【查找是否过此购买过此书】的数据访问，参数：用户id{}，书籍id{}",userId,bookID);
        return ordersRepository.SelectBytRadeStatus(userId,bookID);
    }
    //查询是否买过书(新用户)
    @Override
    public Integer SelectBookNumberBytRadeStatus(Integer userId) {
        log.warn("Service层开始执行【查找是否买过书(新用户)】的数据访问，参数：用户id{}",userId);

        return ordersRepository.SelectBookNumberBytRadeStatus(userId);
    }
}
