package cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.mapper.BannerMapper;
import cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.repository.IBannerRepository;
import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.vo.BannerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class IBannerRepositoryImpl implements IBannerRepository {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerVO> select() {
        return bannerMapper.select();
    }
}
