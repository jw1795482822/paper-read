package cn.tedu.cn_tedu_v1.index.front.service.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.IBookPageRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.entity.BookPage;
import cn.tedu.cn_tedu_v1.index.front.service.IBookPageService;
import cn.tedu.cn_tedu_v1.index.search.pojo.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BookPageServiceImpl implements IBookPageService {
    @Autowired
    IBookPageRepository bookPageRepository;

    public BookPage selectById(Long id){
         return bookPageRepository.selectById(id);
    }

    @Override
    public int save(BookPage bookPage) {
        Long id = bookPage.getBookId();
        if (selectById(id)==null){
            insert(bookPage);
            return bookPageRepository.save(bookPage);
        }
        return bookPageRepository.save(bookPage);
    }
    @Override
    public int insert(BookPage bookPage){
       return bookPageRepository.insert(bookPage);
    }
}
