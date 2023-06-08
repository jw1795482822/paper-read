package cn.tedu.cn_tedu_v1.userv1.controller;


import cn.tedu.cn_tedu_v1.userv1.mapper.SecurityMapper;
import cn.tedu.cn_tedu_v1.userv1.mapper.UserMapper;
import cn.tedu.cn_tedu_v1.userv1.pojo.dto.SecurityDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.dto.UserRegDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.User;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserVO;
import cn.tedu.cn_tedu_v1.userv1.response.ResultVO;
import cn.tedu.cn_tedu_v1.userv1.response.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 处理用户登录注册页面业务流程,检查登录状态
 */
@RestController
@RequestMapping("/v1/users/")
public class UserController {

    static AtomicInteger times = new AtomicInteger(3);
    static AtomicInteger verification = new AtomicInteger(3);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    PasswordEncoder passwordEncoder;


    //注册功能
    @PostMapping("reg")
    public ResultVO insert(@RequestBody UserRegDTO userRegDTO) {

        System.out.println("userRegDTO = " + userRegDTO);

        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        if (userVO != null) {//代表用户名已存在
            return new ResultVO(StatusCode.REPEAT_USER);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user);
        user.setAdmin("user");

        //让密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userMapper.insert(user);
        securityMapper.SecurityUpdate(userRegDTO);
        return new ResultVO(StatusCode.SUCCESS);

        /*UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        if (userVO != null) {
            return new ResultVO(StatusCode.REPEAT_USER);
        }

        userMapper.insert(userRegDTO);
        securityManager.SecurityUpdate(userRegDTO);

        return new ResultVO(StatusCode.SUCCESS);*/
    }

    @Autowired
    AuthenticationManager manager;
    //登录功能
    @PostMapping("login")
    public ResultVO login(@RequestBody UserRegDTO userRegDTO) {
        System.out.println("userRegDTO = " + userRegDTO);
        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        System.out.println(userVO);
        Authentication result = manager.authenticate(new UsernamePasswordAuthenticationToken(
                userRegDTO.getUsername(), userRegDTO.getPassword()));
        //将认证结果保存到Security上下文中   让Security框架记住登录状态
        SecurityContextHolder.getContext().setAuthentication(result);
        return new ResultVO(result.getPrincipal());
        /*//以后考虑下同一个用户名有三次机会
        if (times.get() == 0) {
            return new ResultVO(StatusCode.PASSWORD_ERROR);
        }
        System.out.println("userRegDTO = " + userRegDTO);
        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        if (userVO != null) {
            if (userRegDTO.getPassword().equals(userVO.getPassword())) {
                session.setAttribute("user", userVO);
                return new ResultVO(StatusCode.SUCCESS);
            } else {
                return NumberOfJudgments(times.decrementAndGet());
            }
        }
        return NumberOfJudgments(times.decrementAndGet());*/
    }

    //忘记密码业务逻辑
    @PostMapping("forget")
    public ResultVO forget(@RequestBody SecurityDTO securityDTO) {
        System.out.println(verification.get());
        if (verification.get() == 0) {
            return ForgetThePassword(verification.get());
        }
        System.out.println("securityDTO = " + securityDTO);
        //得到用户密保问题
        //增加修改密码,页面增加两次密码输入框,确认两次密码是否一一致,在前端页面forget.html判断,DTO,
        //里面增加属性密码,判断密保问题正确后同时修改库里密码
        Security security = securityMapper.SecurityBySecurity(securityDTO.getUsername());
        if (security == null)
            return ForgetThePassword(verification.decrementAndGet());
        if (securityDTO.getQuestion().equals(security.getQuestion())) {
            if (securityDTO.getAnswer().equals(security.getAnswer())) {
                //times.set(3);
                //加密修改好的密码
                securityDTO.setPassword(passwordEncoder.encode(securityDTO.getPassword()));
                securityMapper.passwordUpdate(securityDTO);
                return new ResultVO(StatusCode.SUCCESS);
            }
            return ForgetThePassword(verification.decrementAndGet());
        }
        return ForgetThePassword(verification.decrementAndGet());
}


    //登陆状态检查--检查用户进入网站后是否登录--展示首页页面不同
    @GetMapping("currentUser")
    public UserVO currentUser(HttpSession session) {
        UserVO userVO = (UserVO) session.getAttribute("user");
        return userVO;
    }

    //退出登录
    @GetMapping("logout")
    public void logout() {
        //从Security框架中删除认证数据
        SecurityContextHolder.clearContext();
    }

    //忘记密码判断密选择及答案是否正确
    public ResultVO ForgetThePassword(int verification) {
        switch (verification) {
            case 2:
                return new ResultVO(StatusCode.QUESTION_ERROR_TWICE);
            case 1:
                return new ResultVO(StatusCode.QUESTION_ERROR_ONCE);
            case 0:
                return new ResultVO(StatusCode.QUESTION_ERROR);
        }

        return null;
    }

    //判断times登录错误次数,用于抛出对应异常
//    public ResultVO NumberOfJudgments(int times) {
//        switch (times) {
//            case 2:
//                return new ResultVO(StatusCode.PASSWORD_ERROR_TWICE);
//            case 1:
//                return new ResultVO(StatusCode.PASSWORD_ERROR_ONCE);
//            case 0:
//                return new ResultVO(StatusCode.PASSWORD_ERROR);
//        }
//
//        return null;
//    }
}
