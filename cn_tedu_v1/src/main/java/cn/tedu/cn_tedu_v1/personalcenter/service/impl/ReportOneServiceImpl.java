package cn.tedu.cn_tedu_v1.personalcenter.service.impl;

import cn.tedu.cn_tedu_v1.common.ex.ServiceException;
import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.IReportOneRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Report;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.ReportOneParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.ReportOneVO;
import cn.tedu.cn_tedu_v1.personalcenter.service.IReportOneService;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Service
@Slf4j
public class ReportOneServiceImpl implements IReportOneService {
    @Autowired
    private IReportOneRepository reportOneRepository;


    @Override
    public void insert(ReportOneParam reportOneParam) {

        // 判断 插入的BookId 值是否为 null
        if (reportOneParam.getBookId() == null) {
            String message = "BookId 不能为空!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }

        // 判断 插入的UserId 值是否为 null
        if (reportOneParam.getUserId() == null) {
            String message = "UserId 不能为空!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }

        // 判断 插入的LibraryId 值是否为 null
        if (reportOneParam.getLibraryId() == null) {
            String message = "LibraryId 不能为空!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }


        Long userId = reportOneParam.getUserId();
        Long bookId = reportOneParam.getBookId();

        ReportOneVO reportOneVO = reportOneRepository.selectReport(bookId, userId);

        try {
            // 获取当前时间
            LocalDateTime currentTime = LocalDateTime.now();
            // 将 reportOneVO.getGmtModified() 转换为日期时间对象
            LocalDateTime gmtModified = reportOneVO.getGmtModified();
            // 计算当前时间与 gmtModified 之间的时间差（单位：分钟）
            long minutesDifference = ChronoUnit.MINUTES.between(gmtModified, currentTime);

            // 判断时间差是否小于十分钟
            if (minutesDifference < 10) {
                String message = "您已经提交了哟! 我们会抓紧一切时间审核的! 亲! ";
                throw new ServiceException(ServiceCode.ERROR_CONFLICT, message);
            }
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        }


        // 判断   reportOneParam.getSelected()  数组长度是否为0
        if (reportOneParam.getSelected().length == 0) {
            String message = "请至少选择一个选项!!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }


        // 判断举报内容是否为空
        if (reportOneParam.getWrite() == null || reportOneParam.getWrite().equals("")) {
            String message = "举报内容不能为空!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }


        // 将 数组 转换成 字符串
        String string = Arrays.toString(reportOneParam.getSelected());
        reportOneParam.setReportContent(string + "" + reportOneParam.getWrite());

        // 判断 举报详情 不能超过 200个字
        if (reportOneParam.getReportContent().length() > 200) {
            String message = "详情不能超过一百个字 !";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }

        Report report = new Report();
        BeanUtils.copyProperties(reportOneParam, report);
        reportOneRepository.insert(report);
    }
}
