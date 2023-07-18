package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.DateMapper;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IDateRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IDateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = bianmy
 * DATE = 2023/7/15 16:23
 */
@SpringBootTest
public class Test1 {


    @Autowired
    IDateService service;

    @Test
    void a() {
        service.selectUrlByBookId(19L);
    }
}