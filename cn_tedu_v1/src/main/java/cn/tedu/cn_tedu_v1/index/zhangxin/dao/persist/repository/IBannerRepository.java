package cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.repository;

import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.vo.BannerVO;

import java.util.List;

public interface IBannerRepository {

    List<BannerVO> select();
}
