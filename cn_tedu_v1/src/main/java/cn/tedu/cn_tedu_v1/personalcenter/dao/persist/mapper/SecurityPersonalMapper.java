package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.Security;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.SecurityPersonalVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityPersonalMapper extends BaseMapper<Security> {
    /**
     * 查询密保问题 和密保答案
     * @param userId 根据 用户Id 查询  用户的密报问题和答案
     * @return 受影响行数
     */
    SecurityPersonalVO selectsecurity(Long userId);
}
