package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.BookDetailsPageMapper;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookDetailsPageRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookDetailsPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BookCategoryRepositoryImpl implements IBookDetailsPageRepository {
    @Autowired
    private BookDetailsPageMapper bookDetailsPageMapper;


    @Override
    public BookDetailsPage selectById(Long id) {
        log.warn("根据id{}查询文章信息",id);
        return bookDetailsPageMapper.selectById(id);
    }
}
