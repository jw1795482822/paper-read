package cn.tedu.cn_tedu_v1.index.front.service;

import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;

import java.util.List;

public interface ICategoryService {


//    AdvertiseVO getAdverList();
    List<CategoryVO> selectCategory();
}
