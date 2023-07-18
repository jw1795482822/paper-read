package cn.tedu.cn_tedu_v1.index.front.dao.persist.repository;

import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.BookBBVO;

import java.util.List;

public interface IAdvertiseRepository {

    List<AdvertiseVO> selectList();

    List<BookBBVO> BookByBorrow();



}
