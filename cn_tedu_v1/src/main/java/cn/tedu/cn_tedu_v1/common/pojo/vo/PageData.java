package cn.tedu.cn_tedu_v1.common.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 将PageInfo转换成PageData的转换器工具类
 *
 * Author = sun
 * DATE = 2023/6/17 11:21
 */
@Data
@Accessors(chain = true)
public class PageData<T> implements Serializable {
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 记录总数
     */
    private Long total;
    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 最大页码
     */
    private Integer maxPage;
    /**
     * 数据列表
     */
    private List<T> list;
}
