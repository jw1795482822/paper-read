package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.BookDetailsPageMapper;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.DateMapper;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IBookDetailsPageRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IDateRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.BookDetailsPage;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.DateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class DateRepositoryImpl implements IDateRepository {
    @Autowired
    private DateMapper dateMapper;
    @Override
    public String selectUrlByBookId(Long id) {
        log.warn("根据id{}查询文章内容信息",id);
        return dateMapper.selectUrlByBookId(id);
    }
}
