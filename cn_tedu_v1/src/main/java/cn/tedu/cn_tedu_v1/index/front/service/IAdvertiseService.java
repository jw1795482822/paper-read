package cn.tedu.cn_tedu_v1.index.front.service;

import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.BookBBVO;

import java.util.List;

public interface IAdvertiseService {


//    AdvertiseVO getAdverList();
    List<AdvertiseVO> selectList();
    List<BookBBVO> BookByBorrow();

}
