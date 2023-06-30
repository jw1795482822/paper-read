package cn.tedu.cn_tedu_v1.common.util;



import cn.tedu.cn_tedu_v1.common.pojo.vo.PageData;
import com.github.pagehelper.PageInfo;

/**
 * Author = sun
 * DATE = 2023/6/17 11:56
 */
public class PageInfoToPageDataConverter {
    /**
     * 将PageHelper框架中的PageInfo类型对象转换成自定义的PageData类型对象
     *
     * @param pageInfo PageInfo对象
     * @param <T>      PageInfo对象中的列表数据中的元素数据的类型
     * @return 自定义的PageData类型的对象
     */
    public synchronized static <T> PageData<T> convert(PageInfo<T> pageInfo) {
        PageData<T> pageData = new PageData<>();
        pageData.setPageSize(pageInfo.getPageSize())
                .setTotal(pageInfo.getTotal())
                .setCurrentPage(pageInfo.getPageNum())
                .setMaxPage(pageInfo.getPages())
                .setList(pageInfo.getList());
        return pageData;
    }
}
