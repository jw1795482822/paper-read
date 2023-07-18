package cn.tedu.cn_tedu_v1.favorites.pojo.vo;

import lombok.Data;

/**
 * 接受用户ID书籍ID VO类
 * Author = bianmy
 * DATE = 2023/7/18 18:38
 */
@Data
public class FavoritesVo {
    private Long userId;
    private Long bookId;
}