package cn.tedu.cn_tedu_v1.search.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.search.pojo.vo.BookANDLibraryListVO;
import cn.tedu.cn_tedu_v1.search.service.ISearchService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/search")
public class SearchController {
    @Autowired
    private ISearchService searchService ;



    @RequestMapping("/{wd}/search")
    @PreAuthorize("hasAuthority('user')")
    public JsonResult search(@PathVariable String wd){
        log.warn("开始处理 查询语句: {}",wd);
        List<BookANDLibraryListVO> list = searchService.selectByWd(wd);
        //log.warn("查询结果为 : {}" , list );
        return JsonResult.ok(list);
    }

}
