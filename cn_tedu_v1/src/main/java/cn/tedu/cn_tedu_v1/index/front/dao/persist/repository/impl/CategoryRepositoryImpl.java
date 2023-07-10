package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.AdvertiseMapper;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.ICategoryRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/7/9  20:59
 */
@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    @Autowired
    AdvertiseMapper mapper;

    @Override
    public List<CategoryVO> selectCategory() {
        return mapper.selectCategory();
    }
}
