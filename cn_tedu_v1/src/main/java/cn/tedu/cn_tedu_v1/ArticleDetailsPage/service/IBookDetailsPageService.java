package cn.tedu.cn_tedu_v1.ArticleDetailsPage.service;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookDetailsPage;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.BookDetailsPageVO;

public interface IBookDetailsPageService {

    BookDetailsPageVO selectById(Long id);

}
