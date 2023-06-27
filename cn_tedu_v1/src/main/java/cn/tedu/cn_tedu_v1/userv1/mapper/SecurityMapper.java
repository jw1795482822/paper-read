package cn.tedu.cn_tedu_v1.userv1.mapper;


import cn.tedu.cn_tedu_v1.userv1.pojo.dto.SecurityDTO;

import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityMapper  {
    //根据用户名查找密保表实体类
    Security SecurityBySecurity(String username);

    //忘记密码修改密码流程
    void passwordUpdate(SecurityDTO securityDTO);

}