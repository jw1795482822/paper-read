package cn.tedu.cn_tedu_v1.ArticleDetailsPage.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 文章内容
 */
@Data
public class DateVO implements Serializable {
    /**
     * 唯一标识
     * */
    private Long id;
    /**
     * PDF文件URL
     */
    private String pdfUrl;
}
