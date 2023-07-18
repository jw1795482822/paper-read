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
    public void updateInfoById(Long id , UserPersonalCenterParam userPersonalCenterParam) {
        User user = new User();
        BeanUtils.copyProperties(userPersonalCenterParam, user);
        user.setId(id);

        // 设置性别输入格式
        String gender = "^(男|女)$";

        //判断 用户是否输入
        if (userPersonalCenterParam.getGender() == null){
            String message = "性别不能为空!";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }
        // 判断性别是否符合格式
        if (!userPersonalCenterParam.getGender().matches(gender)) {
            String message = "请输入 '男' 或 '女' ";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }

        if (userPersonalCenterParam.getPhoneNumber() == null || userPersonalCenterParam.getPhoneNumber().equals("")){
            String message = "手机号不能为空!";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }

        // 设置手机号输入格式
        String phoneNumber = "^(\\+?\\d{1,3})?[1-9]\\d{4,14}$";
        // 判断手机号是否符合格式
        if (!userPersonalCenterParam.getPhoneNumber().matches(phoneNumber)) {
            String message = "请输入合法手机号!";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }

          // TODO 数据库身份号数据类型为整数    实际需要String 类型
//        // 设置身份证号输入格式
//        String idCardNumber = "^\\d{17}(\\d|X|x)$";
//        // 判断身份证号是否符合格式
//        if (!userPersonalCenterParam.getId_number().matches(idCardNumber)) {
//            String message = "身份证号不合法!";
//            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
//        }

        // 判断昵称 是否为空
        if (userPersonalCenterParam.getNickName() == null || userPersonalCenterParam.getNickName().equals("")){
            String message = "昵称不能为空!";
            throw new ServiceException(ServiceCode.ERROR_UPLOAD_EMPTY, message);
        }
        userPersonalCenterRepository.updateById(user);
    }

    @Override
    public void updateInfoByUserId(UserPersonalParam userPersonalParam) {
        // 根据用户ID查询密保问题以及答案 用来修改密码时和用户输入的答案进行对比
        SecurityPersonalVO selectsecurity = securityPersonalRepository.selectsecurity(userPersonalParam.getId());
        // 查询出 用户现在密码 用来和用户输入的原密码对比
        List<UserPersonalCenterVO> personalCenterVOS = userPersonalCenterRepository.selectList(userPersonalParam.getId());

        // 创建BCryptPasswordEncoder对象
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 现密码
        String password = "";
        for (UserPersonalCenterVO userPersonalCenterVO : personalCenterVOS){
            password = userPersonalCenterVO.getPassword();
            System.out.println("password = " + password);
        }

        // 用户输入的原密码 赋值给 PasswordJ
        String PasswordJ = userPersonalParam.getPasswordJ();

        // 判断用户是否输入原密码
        if (PasswordJ == null || PasswordJ.equals("")){
            String message = "原密码不能为空!";
            throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
        }
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
            if (userPersonalParam.getQuestion().equals(selectsecurity.getQuestion()) && userPersonalParam.getAnswer().equals(selectsecurity.getAnswer())){

                // 设置密码输入格式
                String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
                // 判断密码是否符合格式
                if (!userPersonalParam.getPassword().matches(passwordRegex)) {
                    String message = "密码不符合格式要求!";
                    throw new ServiceException(ServiceCode.ERROR_SECURITY_QUESTION, message);
                }



                User user = new User();
                BeanUtils.copyProperties(userPersonalParam, user);
                user.setId(userPersonalParam.getId());

                // 加密密码
                String encryptedPassword = encoder.encode(userPersonalParam.getPassword());
                // 把用户输入的复制到user对象中
                user.setPassword(encryptedPassword);
                // 使用userPersonalParam对象进行更新
                userPersonalCenterRepository.updateInfoByUserId(user);
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
