package cn.tedu.cn_tedu_v1.favorites.service.impl;

import cn.tedu.cn_tedu_v1.favorites.dao.repository.IFavoritesRepository;
import cn.tedu.cn_tedu_v1.favorites.pojo.entity.Favorites;
import cn.tedu.cn_tedu_v1.favorites.pojo.vo.FavoritesVo;
import cn.tedu.cn_tedu_v1.favorites.service.IFavoritesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 收藏夹功能业务层
 * Author = bianmy
 * DATE = 2023/7/18 18:19
 */
@Repository
public class FavoritesServiceImpl implements IFavoritesService {

    @Autowired
    private IFavoritesRepository favoritesRepository;

    /**
     * 加入收藏夹方法
     */
    @Override
    public void insertById(FavoritesVo favoritesVo) {
        Favorites favorites = new Favorites();
        BeanUtils.copyProperties(favoritesVo, favorites);
        favoritesRepository.insert(favorites);
    }
}