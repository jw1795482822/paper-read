package cn.tedu.cn_tedu_v1.index.bookdeatils.persist.repository;

import cn.tedu.cn_tedu_v1.index.bookdeatils.pojo.vo.BookDeatilsVO;

import java.util.List;

public interface IBookDeatilsRepository {
    List<BookDeatilsVO> listBookDetails();
}
