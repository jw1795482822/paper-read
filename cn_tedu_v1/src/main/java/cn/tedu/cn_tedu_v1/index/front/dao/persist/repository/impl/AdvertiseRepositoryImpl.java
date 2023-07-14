package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.FrontMapper;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.IAdvertiseRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.BookBBVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class AdvertiseRepositoryImpl implements IAdvertiseRepository {

    @Autowired
    FrontMapper mapper;

//    @Override
//    public AdvertiseVO getAdverList() {
//        log.debug("处理查询");
//         return mapper.getAdverList();
//    }

    @Override
    public List<AdvertiseVO> selectList() {
        log.debug("处理查询");
        return mapper.selectList();
    }

    @Override
    public List<BookBBVO> BookByBorrow() {
        return mapper.BookByBorrow();
    }
}
