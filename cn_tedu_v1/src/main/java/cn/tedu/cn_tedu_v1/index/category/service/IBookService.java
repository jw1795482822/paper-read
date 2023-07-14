package cn.tedu.cn_tedu_v1.index.category.service;

import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.BookListItemVO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBookService {
    /**
     * 根据文章类别查询文章列表，将使用默认的每页记录数
     *
     * @param categoryId 文章类别的ID
     * @param pageNum    页码
     * @return 文章列表
     */
    PageData<BookListItemVO> listByCategoryId(Long categoryId, Integer pageNum);

    /**
     * 根据文章类别查询文章列表
     *
     * @param categoryId 文章类别的ID
     * @param pageNum    页码
     * @param pageSize   每页记录数
     * @return 文章列表
     */
    PageData<BookListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize);
}
