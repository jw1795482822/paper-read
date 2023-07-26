package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.BookPageMapper;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.IBookPageRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.entity.BookPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Slf4j
public class BookPageRepositoryImpl implements IBookPageRepository {
    @Autowired
    BookPageMapper bookPageMapper;

    public BookPage selectById(Long id) {
        return bookPageMapper.selectById(id);

    }

    @Override
    public int save(BookPage bookPage) {
        Long bookPageNum=bookPage.getBookPage();
        Long bookid= bookPage.getBookId();
        return bookPageMapper.save(bookPageNum,bookid);
    }

    @Override
    public int insert(BookPage bookPage) {

         return bookPageMapper.insert(bookPage);
    }
}
