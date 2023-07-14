package cn.tedu.cn_tedu_v1.index.category.persist.repository;

import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.BookListItemVO;

public interface IBookRepository {
    /**
     * 根据文章类别查询其文章列表
     *
     * @param categoryId 文章类别的ID
     * @param pageNum    页码
     * @param pageSize   每页记录数
     * @return 文章列表
     */
    PageData<BookListItemVO> listByCategoryId(Long categoryId, Integer pageNum, Integer pageSize);
}
