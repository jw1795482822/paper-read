package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.repository;


public interface IBookOrdersRepository {
    //查询是否拥有此书
    Integer SelectBytRadeStatus(Integer userId,Integer bookID);
    //查询用户是否买过书(新用户)
    Integer SelectBookNumberBytRadeStatus(Integer userId);
}
