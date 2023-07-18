package cn.tedu.cn_tedu_v1.index.search.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookANDLibraryListVO {

    private String author; // 作者名字
    private LocalDateTime publishTime; // 出版时间
    private String name;
    private String publisher;
    private String cover;



}
