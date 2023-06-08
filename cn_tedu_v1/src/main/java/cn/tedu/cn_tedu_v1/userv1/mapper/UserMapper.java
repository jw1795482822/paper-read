package cn.tedu.cn_tedu_v1.userv1.mapper;

import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.User;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserVO;

public interface UserMapper {
    UserVO selectByUserName(String username);

    int insert(User user);
}