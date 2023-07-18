package cn.tedu.cn_tedu_v1.favorites.controller;

import cn.tedu.cn_tedu_v1.common.web.JsonResult;
import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import cn.tedu.cn_tedu_v1.favorites.pojo.vo.FavoritesVo;
import cn.tedu.cn_tedu_v1.favorites.service.IFavoritesService;
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
}