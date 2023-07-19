package cn.tedu.cn_tedu_v1.favorites.service.impl;

import cn.tedu.cn_tedu_v1.common.ex.ServiceException;
import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import cn.tedu.cn_tedu_v1.favorites.dao.repository.IFavoritesRepository;
import cn.tedu.cn_tedu_v1.favorites.pojo.entity.Favorites;
import cn.tedu.cn_tedu_v1.favorites.pojo.vo.FavoritesVo;
import cn.tedu.cn_tedu_v1.favorites.service.IFavoritesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public int selectByUserIdAndBook(Long userId, Long bookId) {
        QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("book_id",bookId);
        int i = favoritesRepository.selectByUserIdAndBook(userId, bookId);
//        if (i > 1){
//            String message = "重复收藏此书";
//            throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
//        }
        return i;
    }
}