package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.index.search.persist.mapper.SearchMapper;
import cn.tedu.cn_tedu_v1.index.search.persist.repository.ISearchRepository;
import cn.tedu.cn_tedu_v1.index.search.pojo.vo.BookANDLibraryListVO;
import cn.tedu.cn_tedu_v1.index.search.service.ISearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SearchTest {
    @Autowired
    ISearchService searchService;

    @Test
    void x(){
        String i = "崔傲";
        List<BookANDLibraryListVO> bookANDLibraryListVOS = searchService.selectByWd(i);
        System.out.println(bookANDLibraryListVOS);
    }



    @Autowired
    ISearchRepository SsearchService;


    @Test
    void xx(){
        String i = "天";
        List<BookANDLibraryListVO> bookANDLibraryListVOS = SsearchService.selectByWd(i);
        System.out.println(bookANDLibraryListVOS);
    }


    @Autowired
    SearchMapper earchService;


    @Test
    void xxx(){
        String wd = "萨达";
        List<BookANDLibraryListVO> bookANDLibraryListVOS = earchService.selectByWd(wd);
        System.out.println(bookANDLibraryListVOS);
    }
}
