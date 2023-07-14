package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository;


import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.DateVO;

public interface IDateRepository {

    DateVO selectUrlByBookId(Long id);

}
