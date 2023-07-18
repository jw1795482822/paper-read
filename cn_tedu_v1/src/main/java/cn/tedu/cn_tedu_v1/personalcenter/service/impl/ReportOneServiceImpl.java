package cn.tedu.cn_tedu_v1.personalcenter.service.impl;

import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.IReportOneRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Report;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;
import cn.tedu.cn_tedu_v1.personalcenter.service.IReportOneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReportOneServiceImpl implements IReportOneService {
    @Autowired
    private IReportOneRepository reportOneRepository;

    @Override
    public void insert(ReportOneParam reportOneParam) {
        Report report = new Report();
        BeanUtils.copyProperties(reportOneParam,report);
        reportOneRepository.insert(report);
    }
}
