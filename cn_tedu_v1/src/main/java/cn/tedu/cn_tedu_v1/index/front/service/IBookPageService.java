package cn.tedu.cn_tedu_v1.index.front.service;


import cn.tedu.cn_tedu_v1.index.front.pojo.entity.BookPage;


public interface IBookPageService {
    BookPage selectById(Long id);
    int save(BookPage bookPage);
    int insert(BookPage bookPage);
}
