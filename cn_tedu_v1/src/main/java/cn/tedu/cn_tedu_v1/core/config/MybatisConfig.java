package cn.tedu.cn_tedu_v1.core.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        {
                "cn.tedu.cn_tedu_v1.userv1.mapper",
                "cn.tedu.cn_tedu_v1.search.persist.mapper",
                "cn.tedu.cn_tedu_v1.bookdeatils.persist.mapper",
                "cn.tedu.cn_tedu_v1.**.**.mapper",
                "cn.tedu.cn_tedu_v1.zhangxin.dao.persist.mapper",
                "cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper",
                "cn.tedu.cn_tedu_v1.ArticleDetailsPage.persist.mapper.DateMapper"
        })
public class MybatisConfig {
}