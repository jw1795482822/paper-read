package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.BookCategoryMapper;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookCategoryRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BookDetailsPageRepositoryImpl implements IBookCategoryRepository {
    @Autowired
    private BookCategoryMapper categoryMapper;


    @Override
    public BookCategory selectCategoryById(Long id) {
        log.warn("根据id{}文章分类信息",id);
        return categoryMapper.selectById(id);
    }
}
