package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository;


import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.User;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.UserPersonalCenterVO;

import java.util.List;

public interface IUserPersonalCenterRepository {
    /**
     * 查看个人信息
     * @param id 根据id 查询信息
     * @return  根据id 查看用户信息
     */
    List<UserPersonalCenterVO> selectList(Long id);

    /**
     * 根据ID修改用户个人信息
     *
     * @param user 封装了ID和用户信息
     */
    void updateById(User user);

    /**
     * 修改密码
     */
    void updateInfoByUserId(User user);

}
