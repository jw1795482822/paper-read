package cn.tedu.cn_tedu_v1.index.bookdeatils.service;

import cn.tedu.cn_tedu_v1.index.bookdeatils.pojo.vo.BookDeatilsVO;

import java.io.IOException;
import java.util.List;

public interface IBookDeatilsService {
    List<BookDeatilsVO> listBookDetails() throws IOException;
}
