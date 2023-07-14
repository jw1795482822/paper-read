package cn.tedu.cn_tedu_v1.index.category.persist.mapper;

import cn.tedu.cn_tedu_v1.index.category.pojo.entity.Category;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.CategoryListItemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
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
