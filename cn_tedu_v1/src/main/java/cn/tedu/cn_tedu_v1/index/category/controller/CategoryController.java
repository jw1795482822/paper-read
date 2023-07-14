package cn.tedu.cn_tedu_v1.index.category.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.index.category.pojo.vo.CategoryListItemVO;
import cn.tedu.cn_tedu_v1.index.category.service.CategoryService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author = sun
 * DATE = 2023/7/13 20:19
 */
@Slf4j
@RestController
@RequestMapping("/v1/categories")
@Validated
@Api(tags = "类别管理")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("")
    @ApiOperation("查询类别数据列表")
    @ApiOperationSupport(order = 420)
    public JsonResult list() {
        log.debug("开始处理【查询类别数据列表】的请求，参数：无");
        List<CategoryListItemVO> categoryListItemVOList = service.list();
        return JsonResult.ok(categoryListItemVOList);
    }

    @GetMapping("/{id:[0-9]+}")
    @ApiOperation("根据父类id查询子类别数据列表")
    @ApiOperationSupport(order = 410)
    public JsonResult listByParentId( @PathVariable @Range(min = 1, message = "请提交有效的文章ID值！") Long parentId) {
        log.debug("开始处理【查询类别数据列表】的请求，参数：无");
        List<CategoryListItemVO> categoryListItemVOList = service.listByParentId(parentId);
        return JsonResult.ok(categoryListItemVOList);
    }
}
