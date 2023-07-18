package cn.tedu.cn_tedu_v1.alipay.controller;

import cn.tedu.cn_tedu_v1.common.util.SnowflakeIdGenerator;
import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过雪花算法生成唯一的订单ID
 * Author = bianmy
 * DATE = 2023/7/18 8:44
 */
@RestController
@RequestMapping("/v1/snowflake")
public class TraceNoController {


    @PostMapping("")
    public JsonResult snowFlake() {
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1,1);
        return JsonResult.ok(idGenerator.nextId());
    }
}