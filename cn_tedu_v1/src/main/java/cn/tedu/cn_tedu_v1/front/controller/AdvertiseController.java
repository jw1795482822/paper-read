package cn.tedu.cn_tedu_v1.front.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.front.pojo.vo.AdvertiseVO;
import cn.tedu.cn_tedu_v1.front.service.IAdvertiseService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/adver")
public class AdvertiseController {
//    8081
    @Autowired
    private IAdvertiseService service ;

    @ApiOperation("查询广告")
    @ApiOperationSupport(order = 100)
    @PostMapping("/{id:[0-9]+}/")
    @PreAuthorize("hasAuthority('/content/tag/update')")
    public JsonResult getAdverById( Long id){
        AdvertiseVO adver = service.getAdverById(id);
        return JsonResult.ok(adver);
    }

}
