package cn.tedu.cn_tedu_v1.index.category.service.impl;

import cn.tedu.cn_tedu_v1.index.category.persist.repository.CategoryRepository;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.CategoryListItemVO;
import cn.tedu.cn_tedu_v1.index.category.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/7/13 20:35
 */
@Slf4j
@Service
public class CategoryListServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("开始处理【查询类别数据列表】的业务，参数：无");
        List<CategoryListItemVO> categoryListItemVOList = repository.list();
        return categoryListItemVOList;
    }

    @Override
    public List<CategoryListItemVO> listByParentId(Long parentId) {
        log.debug("开始处理【查询子类别数据列表】的业务，参数：无");
        List<CategoryListItemVO> categoryListItemVOList = repository.listByParentId(parentId);
        return categoryListItemVOList;
    }
}
