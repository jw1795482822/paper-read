package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.index.category.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/7/13 23:19
 */
@SpringBootTest
public class CategoryTest {
    @Autowired
    CategoryService service;

    @Test
    void list() {
        List<?> list = service.list();
        System.out.println("根据列表数据完成，列表长度：" + list.size());
        for (Object item : list) {
            System.out.println("列表项：" + item);
        }
    }

    @Test
    void listByParentId() {
        List<?> list = service.listByParentId(2L);
        for (Object item : list) {
            System.out.println("列表项：" + item);
        }
    }
}
