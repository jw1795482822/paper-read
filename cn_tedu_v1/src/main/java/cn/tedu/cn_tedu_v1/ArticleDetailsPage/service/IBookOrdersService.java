package cn.tedu.cn_tedu_v1.ArticleDetailsPage.service;

public interface IBookOrdersService {
//根据userId 和bookID 查询是否有权限查看书籍

    Integer SelectBytRadeStatus(Integer userId,Integer bookID);

}
