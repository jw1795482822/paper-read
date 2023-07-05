package cn.tedu.cn_tedu_v1.front.service.impl;

import cn.tedu.cn_tedu_v1.front.dao.persist.repository.IAdvertiseRepository;
import cn.tedu.cn_tedu_v1.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.front.service.IAdvertiseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdvertiseServiceImpl implements IAdvertiseService {
    @Autowired
    IAdvertiseRepository repository;

    @Override
    public AdvertiseVO getAdverById(Long id) {
        return repository.getAdverById(id);
    }
}
