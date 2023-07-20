package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Report;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.ReportOneVO;

public interface IReportOneRepository {
    /**
     * 插入举报信息
     */
    int insert(Report report);


    /**
     * 查询最后修改时间
     * @param bookId 根据ID查询
     * @return 修影响行数
     */
    ReportOneVO selectReport(Long bookId , Long userId);

}
