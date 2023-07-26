package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Report;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.ReportOneVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportOneMapper extends BaseMapper<Report>{

    ReportOneVO selectReport(Long bookId , Long userId);
}
