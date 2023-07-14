package cn.tedu.cn_tedu_v1.index.category.service;

import cn.tedu.cn_tedu_v1.index.category.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CategoryService {
    /**
     * 查询类别数据列表
     *
     * @return 类别数据列表
     */
    List<CategoryListItemVO> list();

    /**
     * 根据id查询子类列表
     *
     * @return 子类数据列表
     */
    List<CategoryListItemVO> listByParentId(Long parentId);
}
