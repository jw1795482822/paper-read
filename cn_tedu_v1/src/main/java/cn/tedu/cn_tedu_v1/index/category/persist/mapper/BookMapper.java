package cn.tedu.cn_tedu_v1.index.category.persist.mapper;

import cn.tedu.cn_tedu_v1.index.category.pojo.entity.Book;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.BookListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 根据类别（categoryId）查询图书列表
     *
     * @param categoryId 文章类别的ID（categoryId）
     * @return 文章列表
     */
    List<BookListItemVO> listByCategoryId(Long categoryId);
}
