package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.SecurityPersonalVO;

import java.util.List;

public interface ISecurityPersonalRepository {
    /**
     * 查询密保问题 和密保答案
     * @param userId 根据 用户Id 查询  用户的密报问题和答案
     * @return 受影响行数
     */
    SecurityPersonalVO selectsecurity(Long userId);
}
