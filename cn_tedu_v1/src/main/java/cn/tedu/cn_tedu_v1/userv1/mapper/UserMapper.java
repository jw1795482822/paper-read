package cn.tedu.cn_tedu_v1.userv1.mapper;

import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.User;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //查找用户名功能
    UserVO selectByUserName(String username);
    //增加用户
    int insert(User user);
    //增加密保问题,与用户注册表绑定,
    void insertSecurity(Security security);


    int selectByEmail(String email);//注册时查找邮箱是否注册
}