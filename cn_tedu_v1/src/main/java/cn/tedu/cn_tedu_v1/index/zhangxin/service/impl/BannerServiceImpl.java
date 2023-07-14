package cn.tedu.cn_tedu_v1.index.zhangxin.service.impl;

import cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.repository.IBannerRepository;
import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.vo.BannerVO;
import cn.tedu.cn_tedu_v1.index.zhangxin.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements IBannerService {
    @Autowired
    IBannerRepository bannerRepository;

    @Override
    public List<BannerVO> select() {
        return bannerRepository.select();
    }
}
