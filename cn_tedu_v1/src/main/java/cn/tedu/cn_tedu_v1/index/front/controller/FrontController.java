package cn.tedu.cn_tedu_v1.index.front.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.BookBBVO;
import cn.tedu.cn_tedu_v1.index.front.pojo.vo.CategoryVO;
import cn.tedu.cn_tedu_v1.index.front.service.IAdvertiseService;
import cn.tedu.cn_tedu_v1.index.front.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/adver")
public class FrontController {
    //    8081
    @Autowired
    private IAdvertiseService service;
    @Autowired
    private ICategoryService categoryService;

    //广告
    @GetMapping("/adverlist")
    public JsonResult getAdverList() {
        List<AdvertiseVO> list = service.selectList();
        return JsonResult.ok(list);
    }

    //查分类
    @GetMapping("/categoryList")
    public JsonResult getCategoryList() {
        List<CategoryVO> list = categoryService.selectCategory();
        return JsonResult.ok(list);
    }

    //根据借阅量展示图书
    @GetMapping("/BookByBorrow")
    public JsonResult BookByBorrow() {
        List<BookBBVO> list = service.BookByBorrow();
        return JsonResult.ok(list);
    }
    //增加浏览量
    @PostMapping("/addBV/{id}")
    public JsonResult AddBorrow(@PathVariable Long id){
        categoryService.addBorrow(id);
        String message = "阅览量增加一次成功";
        log.debug(message);
        return JsonResult.ok();
    }

}
