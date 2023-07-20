package cn.tedu.cn_tedu_v1.ArticleDetailsPage.controller;

import cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo.BookDetailsPageVO;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IBookDetailsPageService;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IBookOrdersService;
import cn.tedu.cn_tedu_v1.ArticleDetailsPage.service.IDateService;
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
@RequestMapping("/v1/BookOrderse")
@Api(tags = "1.0.支付订单-支付订单表管理")
public class BookOrderseController {

    @Autowired
    private IBookOrdersService ordersService;


    @GetMapping("/limit/{userId}/{bookID}")
    @ApiOperation("根据用户id和bookid查询文章内容信息")
    private JsonResult SelectBytRadeStatus(@PathVariable Integer userId,@PathVariable Integer bookID){
        log.warn("开始处理 根据userId和bookID查询是否有权限 userId：{}，bookID：{}",userId,bookID);
        Integer tradeStatus = ordersService.SelectBytRadeStatus(userId, bookID);
        log.debug("tradeStatus：{}",tradeStatus);
        return JsonResult.ok(tradeStatus);
    }
    @GetMapping("/limitNumber/{userId}")
    @ApiOperation("根据id查询是否买过书")
    private JsonResult SelectNumberBytRadeStatus(@PathVariable Integer userId){
        log.warn("开始处理 根据userId查询是否有拥有此书 userId：{}",userId);
        Integer integer = ordersService.SelectBookNumberBytRadeStatus(userId);
        log.debug("tradeStatus：{}",integer);
        return JsonResult.ok(integer);
    }


}
