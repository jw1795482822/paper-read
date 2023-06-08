package cn.tedu.cn_tedu_v1.userv1.mapper;


import cn.tedu.cn_tedu_v1.userv1.pojo.dto.SecurityDTO;

import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;

public interface SecurityMapper {
    Security SecurityBySecurity(String username);

    void passwordUpdate(SecurityDTO securityDTO);

}