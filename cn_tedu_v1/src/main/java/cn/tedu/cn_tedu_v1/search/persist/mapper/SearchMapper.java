package cn.tedu.cn_tedu_v1.search.persist.mapper;

import cn.tedu.cn_tedu_v1.search.pojo.vo.BookANDLibraryListVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchMapper {
    List<BookANDLibraryListVO> selectByWd(String wd);
}