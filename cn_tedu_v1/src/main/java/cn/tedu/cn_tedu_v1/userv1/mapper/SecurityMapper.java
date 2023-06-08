package cn.tedu.cn_tedu_v1.userv1.mapper;


import cn.tedu.cn_tedu_v1.userv1.pojo.dto.SecurityDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.dto.UserRegDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;

public interface SecurityMapper {
    void SecurityUpdate(UserRegDTO userRegDTO);

    Security SecurityBySecurity(String username);

    void passwordUpdate(SecurityDTO securityDTO);

}