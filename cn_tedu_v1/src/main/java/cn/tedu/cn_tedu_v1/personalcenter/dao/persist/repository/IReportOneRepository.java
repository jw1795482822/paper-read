package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Report;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;

public interface IReportOneRepository {
    /**
     * 插入举报信息
     */
    int insert(Report report);
}
