package cn.tedu.cn_tedu_v1.index.search.persist.repository;

import cn.tedu.cn_tedu_v1.index.search.pojo.vo.BookANDLibraryListVO;

import java.util.List;

public interface ISearchRepository {
    List<BookANDLibraryListVO> selectByWd(String wd);

}
