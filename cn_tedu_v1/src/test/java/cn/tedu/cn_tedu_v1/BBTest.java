package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.index.front.controller.FrontController;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.FrontMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author = lee
 * DATE   = 2023/7/14  17:58
 */
@SpringBootTest
public class BBTest {
    @Autowired
    private FrontMapper mapper;
    @Test
    void BBTest(){
        List<?> list = mapper.BookByBorrow();
        System.out.println("根据列表数据完成，列表长度：" + list.size());
        for (Object item : list) {
            System.out.println("列表项：" + item);
        }
    }
}
