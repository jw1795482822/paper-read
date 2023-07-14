package cn.tedu.cn_tedu_v1.index.category.controller;

import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.BookListItemVO;
import cn.tedu.cn_tedu_v1.index.category.service.IBookService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author = sun
 * DATE = 2023/7/14 16:02
 */
@Slf4j
@RestController
@RequestMapping("/books")
@Validated
@Api(tags = "2.1. 书籍管理模块")
public class BookController {

    @Autowired
    private IBookService service;

    @GetMapping("/list-by-category")
    @ApiOperation("根据类别查询书籍列表")
    @ApiOperationSupport(order = 421)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "书籍类别ID", required = true, paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", paramType = "query", dataType = "long")
    })
    public JsonResult listByCategoryId(@Range(message = "请提交有效的文章类别ID值！") Long categoryId,
                                       @Range(min = 1, message = "请提交有效的页码值！") Integer page) {
        log.debug("开始处理【根据类别查询书籍列表】的请求，父级文章：{}，页码：{}", categoryId, page);
        Integer pageNum = page == null ? 1 : page;
        PageData<BookListItemVO> pageData = service.listByCategoryId(categoryId, pageNum);
        return JsonResult.ok(pageData);
    }

}
