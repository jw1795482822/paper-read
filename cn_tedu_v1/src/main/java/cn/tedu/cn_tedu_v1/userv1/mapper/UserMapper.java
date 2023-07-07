package cn.tedu.cn_tedu_v1.userv1.mapper;

import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.User;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 查找用户名功能
     * @param username 用户名
     * @return uservo
     */
    UserVO selectByUserName(String username);

    /**
     * 增加用户
     * @param user 用户实体类
     * @return
     */
    int insert(User user);

    /**
     * 增加密保问题,与用户注册表绑定,
     * @param security 密保问题实体类
     */
    void insertSecurity(Security security);

    /**
     * 注册时查找邮箱是否注册
     * @param email 用户输入的邮箱
     * @return
     */
    int selectByEmail(String email);
}