package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository;


import cn.tedu.cn_tedu_v1.index.front.pojo.entity.BookPage;

public interface IBookPageRepository {
    BookPage selectById(Long id);

    int save(BookPage bookPage);
    int insert(BookPage bookPage);
}
