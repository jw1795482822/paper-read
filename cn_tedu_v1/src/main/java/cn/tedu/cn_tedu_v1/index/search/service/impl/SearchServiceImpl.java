package cn.tedu.cn_tedu_v1.index.search.service.impl;

import cn.tedu.cn_tedu_v1.index.search.persist.repository.ISearchRepository;
import cn.tedu.cn_tedu_v1.index.search.pojo.vo.BookANDLibraryListVO;
import cn.tedu.cn_tedu_v1.index.search.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl implements ISearchService {
    @Autowired
    private ISearchRepository searchRepository;




    @Override
    public List<BookANDLibraryListVO> selectByWd(String wd) {
        List<BookANDLibraryListVO> bookANDLibraryListVOS = searchRepository.selectByWd(wd);
        return bookANDLibraryListVOS;
    }
}
