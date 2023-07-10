package cn.tedu.cn_tedu_v1.index.front.service.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.ICategoryRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;
import cn.tedu.cn_tedu_v1.index.front.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository repository;

//    @Override
//    public AdvertiseVO getAdverList() {
//        return repository.getAdverList();
//    }

    @Override
    public List<CategoryVO> selectCategory() {
//        log.debug("查询广告结果,为{}",queryWrapper);

        return repository.selectCategory();
    }
}
