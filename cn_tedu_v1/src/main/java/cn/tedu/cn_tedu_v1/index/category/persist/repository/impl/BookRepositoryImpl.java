package cn.tedu.cn_tedu_v1.index.category.persist.repository.impl;

import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import cn.tedu.cn_tedu_v1.common.util.PageInfoToPageDataConverter;
import cn.tedu.cn_tedu_v1.index.category.persist.mapper.BookMapper;
import cn.tedu.cn_tedu_v1.index.category.persist.repository.IBookRepository;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.BookListItemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/7/14 16:24
 */
@Slf4j
@Repository
public class BookRepositoryImpl implements IBookRepository {
    @Autowired
    private BookMapper mapper;

    @Override
    public PageData<BookListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookListItemVO> list = mapper.listByCategoryId(categoryId);
        PageInfo<BookListItemVO> pageInfo = new PageInfo<>(list);
        PageData<BookListItemVO> pageData = PageInfoToPageDataConverter.convert(pageInfo);
        return pageData;
    }
}
