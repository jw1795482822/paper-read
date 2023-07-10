package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.AdvertiseMapper;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.repository.IAdvertiseRepository;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class AdvertiseRepositoryImpl implements IAdvertiseRepository {

    @Autowired
    AdvertiseMapper mapper;

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
}
