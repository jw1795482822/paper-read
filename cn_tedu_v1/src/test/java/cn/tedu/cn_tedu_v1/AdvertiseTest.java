package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.index.category.service.CategoryService;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.FrontMapper;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;
import cn.tedu.cn_tedu_v1.index.front.service.ICategoryService;
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
    FrontMapper mapper;
    @Autowired
    ICategoryService categoryService;
    @Test
    void addBorrow(){
        Long id =1l;
        categoryService.addBorrow(id);
    }

    @Test
    void adver(){

        List<AdvertiseVO> queryResult = mapper.selectList();

            System.out.println("查询数据完成，查询结果：" + queryResult);


    }
    @Test
    void Category(){

        List<CategoryVO> queryResult = mapper.selectCategory();

        System.out.println("查询数据完成，查询结果：" + queryResult);

    }
}
