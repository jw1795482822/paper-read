package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.common.ex.ServiceException;
import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import cn.tedu.cn_tedu_v1.index.category.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author = sun
 * DATE = 2023/7/14 16:35
 */
@SpringBootTest
public class BookTest {
    @Autowired
    IBookService service;

    @Test
    void listByCategoryId() {
        Long categoryId = 6L;
        Integer pageNum = 1;
        Integer pageSize = 5;

        try {
            PageData<?> pageData = service.listByCategoryId(categoryId, pageNum, pageSize);
            System.out.println(pageData);
        } catch (ServiceException e) {
            System.out.println(e.getServiceCode().getValue());
            System.out.println(e.getMessage());
        }
    }
}
