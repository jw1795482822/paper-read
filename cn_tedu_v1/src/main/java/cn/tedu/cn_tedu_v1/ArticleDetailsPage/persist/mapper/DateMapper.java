package cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.entity.Date;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.DateVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface DateMapper extends BaseMapper<Date> {
    String selectUrlByBookId(Long id);
}
