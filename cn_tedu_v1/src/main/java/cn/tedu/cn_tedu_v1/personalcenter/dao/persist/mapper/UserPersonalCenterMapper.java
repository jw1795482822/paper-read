package cn.tedu.cn_tedu_v1.personalcenter.dao.persist.mapper;

import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.User;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalCenterParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.SecurityPersonalVO;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.UserPersonalCenterVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * wsk
 */
@Repository
public interface UserPersonalCenterMapper extends BaseMapper<User> {
    /**
     * 查看个人信息
     * @param id 根据id 查询信息
     * @return  根据id 查看用户信息
     */
    List<UserPersonalCenterVO> selectList(Long id);


}
