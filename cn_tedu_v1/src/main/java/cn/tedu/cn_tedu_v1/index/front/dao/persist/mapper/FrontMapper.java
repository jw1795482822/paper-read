package cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper;


import cn.tedu.cn_tedu_v1.index.front.pojo.entity.Advertise;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.BookBBVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrontMapper extends BaseMapper<Advertise> {

    List<AdvertiseVO> selectList();

    List<CategoryVO> selectCategory();

    List<BookBBVO> BookByBorrow();
}