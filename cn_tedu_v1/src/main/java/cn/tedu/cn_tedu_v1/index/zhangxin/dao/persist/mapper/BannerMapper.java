package cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.mapper;

import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.entity.Banner;
import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.vo.BannerVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    List<BannerVO> select();

}
