package cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookDetailsPageRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookCategoryRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookDetailsPage;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookCategory;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.BookDetailsPageVO;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IBookDetailsPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookDetailsPageServiceImpl implements IBookDetailsPageService {
    @Autowired
    private IBookDetailsPageRepository bookDetailsPageRepository;

    @Autowired
    private IBookCategoryRepository categoryRepository;
    @Override
    public BookDetailsPageVO selectById(Long id) {
        BookDetailsPage bookDetailsPage = bookDetailsPageRepository.selectById(id);
        BookCategory category = categoryRepository.selectCategoryById(bookDetailsPage.getCategoryId());

        //待写规则
        BookDetailsPageVO bookDetailsPageVO = new BookDetailsPageVO()
                .setId(bookDetailsPage.getId())
                .setName(bookDetailsPage.getName())
                .setAuthor(bookDetailsPage.getAuthor())
                .setBorrowingVolume(bookDetailsPage.getBorrowingVolume())
                .setIntroduction(bookDetailsPage.getIntroduction())
                .setPublisher(bookDetailsPage.getPublisher())
                .setCover(bookDetailsPage.getCover())
                .setPublishTime(bookDetailsPage.getPublishTime())
                .setCategoryName(category.getName());
        return bookDetailsPageVO;
    }
}
