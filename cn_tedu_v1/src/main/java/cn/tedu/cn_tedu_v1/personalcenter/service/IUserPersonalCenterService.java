package cn.tedu.cn_tedu_v1.personalcenter.service;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalCenterParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.UserPersonalCenterVO;

import java.util.List;

public interface IUserPersonalCenterService {
    /**
     * 查看个人信息
     * @param id 根据id 查询信息
     * @return  根据id 查看用户信息
     */
    List<UserPersonalCenterVO> selectList(Long id);

    /**
     * 修改个人信息
     *
     * @param userPersonalCenterParam 封装了被修改数据的ID和新数据的对象
     */
    void updateInfoById(UserPersonalCenterParam userPersonalCenterParam);
    /**
     * 修改密码
     *
     * @param userPersonalParam 封装了被修改数据的ID和新数据的对象
     */
    void updateInfoByUserId(UserPersonalParam userPersonalParam);
}
