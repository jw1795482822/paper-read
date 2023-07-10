package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository;

import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;

import java.util.List;

public interface ICategoryRepository {
    List<CategoryVO> selectCategory();
}
