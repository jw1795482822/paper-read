package cn.tedu.cn_tedu_v1.search.service;

import cn.tedu.cn_tedu_v1.search.pojo.vo.BookANDLibraryListVO;

import java.util.List;

public interface ISearchService {
    List<BookANDLibraryListVO> selectByWd(String wd);
}
