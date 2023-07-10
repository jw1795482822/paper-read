package cn.tedu.cn_tedu_v1.index.search.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookANDLibraryListVO {

    private Long id;
    private String BookName; // 书名
    private String author; // 作者名字
    private String LibraryName; // 图书馆名
    private String userName; // 用户名
    private String nickName;// 昵称
    private LocalDateTime publishTime; // 出版时间
    private String publisher; // 出版社
    private String cover; // 书籍封面
//    private Long libraryId;
//    private Long categoryId;
//    private Long userId;
//    private String BookName;
//    private String author;
//    private LocalDateTime publishTime;
//    private String publisher;
//    private String status;
//    private String cover;
//    private String storeAmount;
//    private Integer sort;
//    private String introduction;
//    private Integer borrowingVolume;
//
//
//
//
//    /**
//     * 图书馆名称
//     */
//    private String LibraryName;
//    /**
//     * 图书馆地址
//     */
//    private String address;
//    /**
//     * 借阅规则
//     */
//    private String rule;
//    /**
//     * 图书馆访问数量
//     */
//    private Integer clickNum;
//
//
//
//
//
//
//    private String userName;
//    private String nickName;
//    private String password;
//    private String admin;
//    private String gender;
//    private String phoneNumber;
//    private Long idNumber;
//    private double account;
//    private String email;
//    private Date createTime;
//    private Date updateTime;


}
