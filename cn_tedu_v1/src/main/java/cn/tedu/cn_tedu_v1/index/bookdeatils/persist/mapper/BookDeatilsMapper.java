package cn.tedu.cn_tedu_v1.index.bookdeatils.persist.mapper;

import cn.tedu.cn_tedu_v1.index.bookdeatils.pojo.vo.BookDeatilsVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDeatilsMapper  {
    /**
     * 统计查询
     * @return 统计查询
     */
    List<BookDeatilsVO> listBookDetails();
}
