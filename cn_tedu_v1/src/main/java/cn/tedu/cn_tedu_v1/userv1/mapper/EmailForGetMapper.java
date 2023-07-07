package cn.tedu.cn_tedu_v1.userv1.mapper;

import cn.tedu.cn_tedu_v1.userv1.pojo.dto.EmailDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.EmailForGetVO;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailForGetMapper {

    /**
     * 邮箱找回密码逻辑
     * @param email 输入邮箱
     * @return 库里查询到的用户信息
     */
    EmailForGetVO selectByEmail(String email);

    /**
     * 根据邮箱修改密码,邮箱唯一
     * @param emailDTO  用户输入的信息
     * @return
     */
    int updateByEmail(EmailDTO emailDTO);
}
