package cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper;

import cn.tedu.cn_tedu_v1.index.front.pojo.entity.BookPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPageMapper extends BaseMapper<BookPage> {
        BookPage selectById(Long id);
        //保存当前页码
        int save(Long bookPageNum,Long bookid);
        int insert(BookPage bookPage) ;
}
