package cn.tedu.cn_tedu_v1.bookdeatils.controller;

import cn.tedu.cn_tedu_v1.bookdeatils.pojo.vo.BookDeatilsVO;
import cn.tedu.cn_tedu_v1.bookdeatils.service.IBookDeatilsService;
import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
    @RequestMapping("v1/bookDeatils")
public class BookDeatilsController {
    @Autowired
    private IBookDeatilsService bookDeatilsService ;

    @RequestMapping("/{A}/bookDetails")
    private JsonResult bookDeatils(String A) throws IOException {
        log.warn("开始处理 查询:{}",A);
        List<BookDeatilsVO> list=bookDeatilsService.listBookDetails(A);
        return JsonResult.ok(list);
    }


}
