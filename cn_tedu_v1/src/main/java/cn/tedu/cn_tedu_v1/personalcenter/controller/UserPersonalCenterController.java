package cn.tedu.cn_tedu_v1.personalcenter.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.index.search.pojo.vo.BookANDLibraryListVO;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.ISecurityPersonalRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.User;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalCenterParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.SecurityPersonalVO;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.UserPersonalCenterVO;
import cn.tedu.cn_tedu_v1.personalcenter.service.IUserPersonalCenterService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * wsk
 */
@Slf4j
@RestController
@RequestMapping("/v1/personal")
public class UserPersonalCenterController {
    @Autowired
    private IUserPersonalCenterService userPersonalCenterService;
    @Autowired
    private ISecurityPersonalRepository securityPersonalRepository;


    @GetMapping("/center/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public JsonResult search(@PathVariable Long id){
        log.warn("开始处理 查询语句: {}",id);
        List<UserPersonalCenterVO> list = userPersonalCenterService.selectList(id);
        return JsonResult.ok(list);
    }


    @ApiOperation("修改个人信息")
    @ApiOperationSupport(order = 300)
    @PostMapping("/{id}/update/info")
    public JsonResult updateInfoById(@Validated UserPersonalCenterParam userPersonalCenterParam) {
        log.debug("开始处理【修改个人信息】的请求，参数：{}", userPersonalCenterParam);
        userPersonalCenterService.updateInfoById(userPersonalCenterParam);
        return JsonResult.ok();
    }



    @ApiOperation("修改密码")
    @ApiOperationSupport(order = 301)
    @PostMapping("/{id}/insert/info")
    public JsonResult updateInfoByUserId(@Validated UserPersonalParam userPersonalParam , Long id) {
        log.debug("开始处理【修改密码】的请求，参数：{}", userPersonalParam);
        securityPersonalRepository.selectsecurity(id);
        userPersonalCenterService.updateInfoByUserId(userPersonalParam);
        return JsonResult.ok();
    }



}
