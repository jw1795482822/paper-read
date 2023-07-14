package cn.tedu.cn_tedu_v1.index.category.persist.repository;

import cn.tedu.cn_tedu_v1.index.category.pojo.vo.CategoryListItemVO;

import java.util.List;

public interface CategoryRepository {
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
