package cn.tedu.cn_tedu_v1.index.zhangxin.controller;


import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.index.zhangxin.service.IBannerService;
import cn.tedu.cn_tedu_v1.index.zhangxin.pojo.vo.BannerVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/front/banner/")
@Api(tags = "轮播图管理")
public class BannerController {
    @Autowired
    private IBannerService bannerService;

    @GetMapping("")
    public JsonResult select(){
        List<BannerVO> list = bannerService.select();
        return JsonResult.ok(list);
    }


}
