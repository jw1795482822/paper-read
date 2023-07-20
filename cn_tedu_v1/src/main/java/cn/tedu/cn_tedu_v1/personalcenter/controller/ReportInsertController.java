package cn.tedu.cn_tedu_v1.personalcenter.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalParam;
import cn.tedu.cn_tedu_v1.personalcenter.service.IReportOneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/insertJwJw")
public class ReportInsertController {
    @Autowired
    private IReportOneService reportOneService;

    public ReportInsertController() {
        log.debug("开始执行,ReportInsertController");
        log.debug("开始执行,ReportInsertController");
        log.debug("开始执行,ReportInsertController");
        log.debug("开始执行,ReportInsertController");
    }


    @ApiOperation("插入举报信息")
    @ApiOperationSupport(order = 201)
    @PostMapping("/report/")
    @PreAuthorize("hasAuthority('admin')")
    public JsonResult updateInfoByUserId(@RequestBody ReportOneParam reportOneParam) {
        log.debug("开始处理【根据 userID ， bookID 新增举报数据】");
        reportOneService.insert(reportOneParam);
        return JsonResult.ok();
    }

}
