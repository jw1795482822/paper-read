package cn.tedu.cn_tedu_v1.location.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.location.pojo.vo.LocationResponse;
import cn.tedu.cn_tedu_v1.location.service.ILocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Author = bianmy
 * 处理IP查询地址请求
 * DATE = 2023/7/7 23:57
 */
@RestController
@RequestMapping("/v1/location/")
@Slf4j
public class LocationController {

    @Autowired
    private ILocationService locationService;

    /**
     * 接受前端请求获取IP,查询地址
     *
     * @param request 获取到用户IP
     * @return
     */
    @GetMapping("ip")
    public JsonResult getLocation(@ApiIgnore HttpServletRequest request) throws IOException {
        //获取当前访问IP
        String ip = request.getRemoteAddr();
        log.info("获取到的IP{}", ip);
        LocationResponse location = locationService.getLocation(ip);
        return JsonResult.ok(location);
    }

}