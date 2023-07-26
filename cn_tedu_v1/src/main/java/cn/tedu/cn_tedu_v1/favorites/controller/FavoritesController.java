package cn.tedu.cn_tedu_v1.favorites.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import cn.tedu.cn_tedu_v1.favorites.pojo.vo.FavoritesVo;
import cn.tedu.cn_tedu_v1.favorites.service.IFavoritesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收藏夹功能模块请求
 * Author = bianmy
 * DATE = 2023/7/18 18:29
 */
@RestController
@RequestMapping("/v1/favorites")
@Slf4j
public class FavoritesController {

    @Autowired
    private IFavoritesService favoritesService;


    /**
     * 添加收藏夹方法
     * @param favoritesVo
     * @return
     */
    @PostMapping("addbook")
    public JsonResult insertById(@RequestBody  FavoritesVo favoritesVo) {
        if (favoritesVo.getUserId() == null || favoritesVo.getBookId() == null) {
            String message = "参数不能为空";
            return JsonResult.fail(ServiceCode.ERROR_NOT_NULL,message);
        }
        favoritesService.insertById(favoritesVo);
        return JsonResult.ok();
    }
    @PostMapping("selectbook")
    public JsonResult selectByUserIdAndBook(@RequestBody  FavoritesVo favoritesVo){
        log.warn("通过bookid{}和userid{}查看用户是否添加到了此书的收藏/书架",favoritesVo.getBookId(),favoritesVo.getUserId());
        if (favoritesVo.getUserId() == null || favoritesVo.getBookId() == null) {
            String message = "参数不能为空";
            return JsonResult.fail(ServiceCode.ERROR_NOT_NULL,message);
        }
        int i = favoritesService.selectByUserIdAndBook(favoritesVo.getBookId(), favoritesVo.getUserId());
        log.debug("查询最终数量{}",i);
        if (i>=1){
            String message = "重复收藏此书";
            return JsonResult.fail(ServiceCode.ERROR_CONFLICT, message);
        }
        return JsonResult.ok(i);
    }
}