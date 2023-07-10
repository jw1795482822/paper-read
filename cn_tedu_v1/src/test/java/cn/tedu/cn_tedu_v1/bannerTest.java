package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.index.zhangxin.dao.persist.mapper.BannerMapper;
import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.vo.BannerVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/7/9  20:30
 */
@SpringBootTest
public class bannerTest {
    @Autowired
    BannerMapper bannerMapper;
    @Test
    void select(){
        List<BannerVO> select = bannerMapper.select();
        System.out.println("查询数据完成，查询结果：" + select);

    }

}
