package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookDetailsPage;

public interface IBookDetailsPageRepository {

    BookDetailsPage selectById(Long id);

}
