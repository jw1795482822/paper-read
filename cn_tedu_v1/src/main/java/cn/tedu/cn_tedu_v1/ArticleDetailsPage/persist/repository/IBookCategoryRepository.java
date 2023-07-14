package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository;


import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookCategory;

public interface IBookCategoryRepository {

    BookCategory selectCategoryById(Long id);

}
