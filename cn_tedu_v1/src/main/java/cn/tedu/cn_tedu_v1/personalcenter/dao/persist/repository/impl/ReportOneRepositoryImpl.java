package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper.ReportOneMapper;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.IReportOneRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Report;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.ReportOneVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class ReportOneRepositoryImpl implements IReportOneRepository {
    @Autowired
    private ReportOneMapper reportOneMapper;

    public ReportOneRepositoryImpl() {
        log.debug("开始处理举报信息!");
    }

    @Override
    public int insert(Report report) {
        log.debug("开始执行【插入 举报信息】 参数: {}" ,report);
        return reportOneMapper.insert(report);
    }

    @Override
    public ReportOneVO selectReport(Long bookId , Long userId) {
        log.debug("开始执行【根据ID查询最后修改时间】 参数: {} , {}" ,bookId , userId);
        ReportOneVO reportOneVO = reportOneMapper.selectReport(bookId , userId);
        return reportOneVO;
    }
}
