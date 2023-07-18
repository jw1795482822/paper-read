package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper.SecurityPersonalMapper;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.ISecurityPersonalRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.SecurityPersonalVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * wsk
 * 查询密保问题 以及密保答案
 */
@Repository
@Slf4j
public class SecurityPersonalRepositoryImpl implements ISecurityPersonalRepository {
    @Autowired
    private SecurityPersonalMapper securityPersonalMapper;

    public SecurityPersonalRepositoryImpl() {
        log.debug("开始执行根据用户ID查询用户密保问题答案");
    }

    @Override
    public List<SecurityPersonalVO> selectsecurity(Long userId) {
        log.debug("开始查询[密保问题 密保答案] : {}" , userId);
        return securityPersonalMapper.selectsecurity(userId);
    }
}
