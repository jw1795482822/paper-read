package cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.impl;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository.IDateRepository;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.DateVO;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IDateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DateServiceImpl implements IDateService {
    @Autowired
    private IDateRepository dateRepository;
    @Override
    public String selectUrlByBookId(Long id) {
        log.warn("根据id{}查询文章内容信息",id);

        return dateRepository.selectUrlByBookId(id);
    }
}
