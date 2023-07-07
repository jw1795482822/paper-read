package cn.tedu.cn_tedu_v1.bookdeatils.service;

import cn.tedu.cn_tedu_v1.bookdeatils.pojo.vo.BookDeatilsVO;

import java.io.IOException;
import java.util.List;

public interface IBookDeatilsService {
    List<BookDeatilsVO> listBookDetails() throws IOException;
}
