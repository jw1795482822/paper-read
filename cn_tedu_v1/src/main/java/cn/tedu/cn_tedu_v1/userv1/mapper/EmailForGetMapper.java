package cn.tedu.cn_tedu_v1.userv1.mapper;

import cn.tedu.cn_tedu_v1.userv1.pojo.dto.EmailDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.EmailForGetVO;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailForGetMapper {

    //邮箱找回密码逻辑
    EmailForGetVO selectByEmail(String email);

    //根据邮箱修改密码
    int updateByEmail(EmailDTO emailDTO);
}
