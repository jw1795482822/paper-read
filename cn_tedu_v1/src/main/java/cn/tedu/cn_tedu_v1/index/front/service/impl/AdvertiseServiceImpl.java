package cn.tedu.cn_tedu_v1.index.front.service.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.IAdvertiseRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.BookBBVO;
import cn.tedu.cn_tedu_v1.index.front.service.IAdvertiseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdvertiseServiceImpl implements IAdvertiseService {
    @Autowired
    IAdvertiseRepository repository;

//    @Override
//    public AdvertiseVO getAdverList() {
//        return repository.getAdverList();
//    }

    @Override
    public List<AdvertiseVO> selectList() {
//        log.debug("查询广告结果,为{}",queryWrapper);

        return repository.selectList();
    }

    @Override
    public List<BookBBVO> BookByBorrow() {
        return repository.BookByBorrow();
    }
}
