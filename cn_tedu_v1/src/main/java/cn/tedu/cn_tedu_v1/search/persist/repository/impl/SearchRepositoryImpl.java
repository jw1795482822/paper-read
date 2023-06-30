package cn.tedu.cn_tedu_v1.search.persist.repository.impl;

import cn.tedu.cn_tedu_v1.search.persist.mapper.SearchMapper;
import cn.tedu.cn_tedu_v1.search.persist.repository.ISearchRepository;
import cn.tedu.cn_tedu_v1.search.pojo.vo.BookANDLibraryListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class SearchRepositoryImpl implements ISearchRepository {
    @Autowired
    private SearchMapper searchMapper;


    @Override
    public List<BookANDLibraryListVO> selectByWd(String wd) {
        return searchMapper.selectByWd(wd);
    }
}
