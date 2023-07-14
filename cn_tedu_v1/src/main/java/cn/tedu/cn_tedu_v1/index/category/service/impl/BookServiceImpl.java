package cn.tedu.cn_tedu_v1.index.category.service.impl;

import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import cn.tedu.cn_tedu_v1.index.category.persist.repository.IBookRepository;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.BookListItemVO;
import cn.tedu.cn_tedu_v1.index.category.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author = sun
 * DATE = 2023/7/14 16:28
 */
@Slf4j
@Service
public class BookServiceImpl implements IBookService {
    @Value("${zhipian-shop.dao.default-query-page-size}")
    private Integer defaultQueryPageSize;
    @Autowired
    private IBookRepository repository;

    @Override
    public PageData<BookListItemVO> listByCategoryId(Long categoryId, Integer pageNum) {
        PageData<BookListItemVO> pageData = repository.listByCategoryId(categoryId, pageNum, defaultQueryPageSize);
        return pageData;
    }

    @Override
    public PageData<BookListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize) {
        PageData<BookListItemVO> pageData = repository.listByCategoryId(categoryId, pageNum, pageSize);
        return pageData;
    }
}
