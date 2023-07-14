package cn.tedu.cn_tedu_v1.index.category.persist.repository.impl;

import cn.tedu.cn_tedu_v1.index.category.persist.mapper.CategoryMapper;
import cn.tedu.cn_tedu_v1.index.category.persist.repository.CategoryRepository;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.CategoryListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/7/13 20:21
 */
@Slf4j
@Repository
public class CategoryListRepositoryImpl implements CategoryRepository {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始执行【查询类别列表】的数据访问，参数：无");
        return mapper.list();
    }

    @Override
    public List<CategoryListItemVO> listByParentId(Long parentId) {
        log.debug("开始执行【查询子类别列表】的数据访问，参数：无");
        return mapper.listByParentId(parentId);
    }
}
