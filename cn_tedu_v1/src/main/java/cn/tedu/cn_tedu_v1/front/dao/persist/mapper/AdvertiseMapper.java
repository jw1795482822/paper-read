package cn.tedu.cn_tedu_v1.front.dao.persist.mapper;


import cn.tedu.cn_tedu_v1.front.pojo.entity.Advertise;
import cn.tedu.cn_tedu_v1.front.pojo.vo.AdvertiseVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertiseMapper extends BaseMapper<Advertise> {

    List<AdvertiseVO> selectList();



}