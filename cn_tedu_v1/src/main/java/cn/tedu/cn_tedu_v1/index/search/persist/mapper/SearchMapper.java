package cn.tedu.cn_tedu_v1.index.search.persist.mapper;

import cn.tedu.cn_tedu_v1.index.search.pojo.vo.BookANDLibraryListVO;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SearchMapper {
    List<BookANDLibraryListVO> selectByWd(String wd);
}