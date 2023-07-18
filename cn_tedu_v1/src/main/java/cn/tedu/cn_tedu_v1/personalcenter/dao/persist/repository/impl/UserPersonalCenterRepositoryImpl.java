package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.impl;

import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper.SecurityPersonalMapper;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper.UserPersonalCenterMapper;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.IUserPersonalCenterRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.User;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalCenterParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.UserPersonalCenterVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserPersonalCenterRepositoryImpl implements IUserPersonalCenterRepository {
    @Autowired
    private UserPersonalCenterMapper userPersonalCenterMapper;



    public UserPersonalCenterRepositoryImpl() {
        log.debug("开始执行根据ID查询用户信息!!");
    }

    @Override
    public List<UserPersonalCenterVO> selectList(Long id) {
        log.debug("根据ID查询用户信息 : {}" , id);
        return userPersonalCenterMapper.selectList(id);
    }

    @Override
    public void updateById(User user) {
        log.debug("开始执行【根据ID修改个人信息数据】，参数：{}", user);
        userPersonalCenterMapper.updateById(user);
    }

    @Override
    public void updateInfoByUserId(User user) {
        log.debug("开始处理修改密码 {}" ,user);
        userPersonalCenterMapper.updateById(user);
    }


}
