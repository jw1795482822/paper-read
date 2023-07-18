package cn.tedu.cn_tedu_v1.favorites.dao.repository;

import cn.tedu.cn_tedu_v1.favorites.pojo.entity.Favorites;

/**
 * Author = bianmy
 * DATE = 2023/7/18 18:12
 */
public interface IFavoritesRepository {

    /**
     * 添加收藏方法
     * @param favorites 收藏夹实体类
     */
    void insert(Favorites favorites);
}