package cn.tedu.cn_tedu_v1.bookdeatils.persist.repository;

import cn.tedu.cn_tedu_v1.bookdeatils.pojo.vo.BookDeatilsVO;

import java.util.List;

public interface IBookDeatilsRepository {
    List<BookDeatilsVO> listBookDeatils(String A);
}
