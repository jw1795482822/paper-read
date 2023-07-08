package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.front.dao.persist.mapper.AdvertiseMapper;
import cn.tedu.cn_tedu_v1.front.pojo.vo.AdvertiseVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/6/30  21:30
 */
@SpringBootTest
public class AdvertiseTest {
    @Autowired
    AdvertiseMapper mapper;
    @Test
    void adver(){

        List<AdvertiseVO> queryResult = mapper.selectList();

            System.out.println("查询数据完成，查询结果：" + queryResult);


    }
}
