package cn.tedu.cn_tedu_v1.index.front.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.index.front.dao.persist.mapper.BookPageMapper;
import cn.tedu.cn_tedu_v1.index.front.pojo.entity.BookPage;
import cn.tedu.cn_tedu_v1.index.front.service.IBookPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author = lee
 * DATE   = 2023/7/19  21:29
 */
@Slf4j
@RestController
@RequestMapping("/v1/adver")
public class BookPageController {
    @Autowired
    IBookPageService bookPageService;

    @PostMapping("/book/{id}")
    public JsonResult selectById(@PathVariable Long id) {
        BookPage bookPage = bookPageService.selectById(id);
        return JsonResult.ok(bookPage);
    }

    @PostMapping("/bookPage")
    public JsonResult save(@RequestBody BookPage bookPage) {

        bookPageService.save(bookPage);
        return JsonResult.ok();
    }


}
