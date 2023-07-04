package cn.tedu.cn_tedu_v1.bookdeatils.persist.mapper;

import cn.tedu.cn_tedu_v1.bookdeatils.pojo.entity.BookDeatils;
import cn.tedu.cn_tedu_v1.bookdeatils.pojo.vo.BookDeatilsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDeatilsMapper  {
    List<BookDeatilsVO> listBookDetails(String A);
}
