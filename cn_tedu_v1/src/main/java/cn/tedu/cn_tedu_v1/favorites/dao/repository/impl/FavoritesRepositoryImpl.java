package cn.tedu.cn_tedu_v1.favorites.dao.repository.impl;

import cn.tedu.cn_tedu_v1.favorites.dao.mapper.FavoritesMapper;
import cn.tedu.cn_tedu_v1.favorites.dao.repository.IFavoritesRepository;
import cn.tedu.cn_tedu_v1.favorites.pojo.entity.Favorites;
import cn.tedu.cn_tedu_v1.favorites.pojo.vo.FavoritesVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author = bianmy
 * DATE = 2023/7/18 18:13
 */
@Repository
public class FavoritesRepositoryImpl implements IFavoritesRepository {

    @Autowired
    private FavoritesMapper favoritesMapper;

    /**
     * 添加收藏方法
     * @param favorites 收藏夹实体类
     */
    @Override
    public void insert(Favorites favorites) {
        favoritesMapper.insert(favorites);
    }

    //根据userid和bookid查询用户订单数量
    @Override
    public int selectByUserIdAndBook(Long userId ,Long bookId) {
        QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("book_id",bookId);
        return favoritesMapper.selectCount(queryWrapper);
    }
}