package cn.tedu.cn_tedu_v1.bookdeatils.persist.repository.impl;

import cn.tedu.cn_tedu_v1.bookdeatils.persist.mapper.BookDeatilsMapper;
import cn.tedu.cn_tedu_v1.bookdeatils.persist.repository.IBookDeatilsRepository;
import cn.tedu.cn_tedu_v1.bookdeatils.pojo.vo.BookDeatilsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class BookDeatilsRepositoryImpl implements IBookDeatilsRepository {
    @Autowired
    private BookDeatilsMapper bookDeatilsMapper;



    @Override
    public List<BookDeatilsVO> listBookDetails() {
        return bookDeatilsMapper.listBookDetails();
    }
}
