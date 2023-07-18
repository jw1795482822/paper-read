package cn.tedu.cn_tedu_v1.ArticleDetailsPage.controller;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.BookDetailsPageVO;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IBookDetailsPageService;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IDateService;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IBookOrdersService;
import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/bookDetailsPage")
@Api(tags = "1.0.图书管理-图书详情")
public class BookDetailsPageController {
    @Autowired
    private IBookDetailsPageService bookDetailsPageService;
    @Autowired
    private IDateService dateService;
    @Autowired
    private IBookOrdersService ordersService;

    @GetMapping("/Basic-information/{id}")
    @ApiOperation("根据id查询文章基本信息")
    private JsonResult BookDetailsPage(@PathVariable Long id){
        log.warn("开始处理 文章基本信息的查询 根据id:{}",id);
        BookDetailsPageVO bookDetailsPageVO = bookDetailsPageService.selectById(id);
        return JsonResult.ok(bookDetailsPageVO);
    }

    @GetMapping("/limit/{userId}/{bookID}")
    @ApiOperation("根据id查询文章内容信息")
    private JsonResult SelectBytRadeStatus(@PathVariable Integer userId,@PathVariable Integer bookID){
        log.warn("开始处理 根据userId和bookID查询是否有权限 userId：{}，bookID：{}",userId,bookID);
        Integer tradeStatus = ordersService.SelectBytRadeStatus(userId, bookID);

        log.debug("tradeStatus：{}",tradeStatus);
        return JsonResult.ok(tradeStatus);
    }
    @GetMapping("/Article-content/{id}")
    @ApiOperation("根据id查询文章内容信息")
    private JsonResult selectUrlByBookId(@PathVariable Long id){
        log.warn("开始处理 文章内容信息的查询 根据id:{}",id);
        log.debug("controller：{}",dateService.selectUrlByBookId(id));
        return JsonResult.ok(dateService.selectUrlByBookId(id));
    }

}
