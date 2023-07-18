package cn.tedu.cn_tedu_v1.personalcenter.service;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;

public interface IReportOneService {
    /**
     * 插入举报信息
     * @param reportOneParam 封装了需要插入的信息
     */
    void insert(ReportOneParam reportOneParam);
}
