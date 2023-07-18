package cn.tedu.cn_tedu_v1.personalcenter.service.impl;

import cn.tedu.cn_tedu_v1.common.ex.ServiceException;
import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.ISecurityPersonalRepository;
import cn.tedu.cn_tedu_v1.personalcenter.dao.persist.repository.IUserPersonalCenterRepository;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.entity.User;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalCenterParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.param.UserPersonalParam;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.SecurityPersonalVO;
import cn.tedu.cn_tedu_v1.personalcenter.pojo.vo.UserPersonalCenterVO;
import cn.tedu.cn_tedu_v1.personalcenter.service.IUserPersonalCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserPersonalCenterServiceImpl implements IUserPersonalCenterService {
    @Autowired
    private IUserPersonalCenterRepository userPersonalCenterRepository;

    @Autowired
    private ISecurityPersonalRepository securityPersonalRepository;

    public UserPersonalCenterServiceImpl() {
        log.debug("开始处理查询用户信息!");
    }

    @Override
    public List<UserPersonalCenterVO> selectList(Long id) {
        log.debug("开始处理[根据ID查询] 用户信息 : {}" , id);
        return userPersonalCenterRepository.selectList(id);
    }

    @Override
    public void updateInfoById(UserPersonalCenterParam userPersonalCenterParam) {
        User user = new User();
        BeanUtils.copyProperties(userPersonalCenterParam, user);
        user.setId(userPersonalCenterParam.getId());
        if (userPersonalCenterParam.getNick_name() == null || userPersonalCenterParam.getNick_name().equals("")){
            String message = "昵称不能为空!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }
        userPersonalCenterRepository.updateById(user);
    }

    @Override
    public void updateInfoByUserId(UserPersonalParam userPersonalParam) {
        User user = new User();
        BeanUtils.copyProperties(userPersonalParam, user);
        user.setId(userPersonalParam.getUserID());

        // 根据用户ID查询密保问题以及答案 用来修改密码时和用户输入的答案进行对比
        List<SecurityPersonalVO> selectsecurity = securityPersonalRepository.selectsecurity(userPersonalParam.getUserID());
        // 查询出 用户现在密码 用来和用户输入的原密码对比
        List<UserPersonalCenterVO> personalCenterVOS = userPersonalCenterRepository.selectList(userPersonalParam.getUserID());

        // 创建BCryptPasswordEncoder对象
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 问题
        String question = "";
        // 答案
        String answer = "";
        // 现密码
        String password = "";
        for (UserPersonalCenterVO userPersonalCenterVO : personalCenterVOS){
            password = userPersonalCenterVO.getPassword();
            System.out.println("password = " + password);
        }

        // 遍历列表中的每个SecurityPersonalVO对象并进行处理
        for (SecurityPersonalVO securityPersonalVO : selectsecurity) {
            // 访问SecurityPersonalVO对象的属性
            question = securityPersonalVO.getQuestion();
            answer = securityPersonalVO.getAnswer();
            System.out.println("question = " + question);
            System.out.println("answer = " + answer);
        }

        // 用户输入的原密码 赋值给 PasswordJ
        String PasswordJ = userPersonalParam.getPasswordJ();
        // 判断原密码和用户输入的原密码是否一致
        if (encoder.matches(PasswordJ, password)) {
            // 判断密保
            if (userPersonalParam.getQuestion()==null || userPersonalParam.getQuestion().equals("")){
                String message = "请输入密保问题!";
                throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
            }else if (userPersonalParam.getAnswer()==null || userPersonalParam.getAnswer().equals("")){
                String message = "请输入密保答案!";
                throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
            }
            if (userPersonalParam.getQuestion().equals(question) && userPersonalParam.getAnswer().equals(answer)){

                // 设置密码输入格式
                String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
                // 判断密码是否符合格式
                if (!userPersonalParam.getPassword().matches(passwordRegex)) {
                    String message = "密码不符合格式要求!";
                    throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
                }
                // 加密密码
                String encryptedPassword = encoder.encode(userPersonalParam.getPassword());
                // 把用户输入的复制到user对象中
                user.setPassword(encryptedPassword);
                // 使用userPersonalParam对象进行更新
                userPersonalCenterRepository.updateById(user);
            }else {
                String message = "密保问题或答案错误!";
                throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
            }
        }else{
            String message = "原密码输入错误!";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }

    }

}
