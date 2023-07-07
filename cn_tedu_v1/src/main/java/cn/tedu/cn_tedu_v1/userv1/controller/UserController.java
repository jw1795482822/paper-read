package cn.tedu.cn_tedu_v1.userv1.controller;


import cn.tedu.cn_tedu_v1.userv1.SnowflakeIdGenerator;
import cn.tedu.cn_tedu_v1.userv1.mapper.EmailForGetMapper;
import cn.tedu.cn_tedu_v1.userv1.mapper.SecurityMapper;
import cn.tedu.cn_tedu_v1.userv1.mapper.UserMapper;
import cn.tedu.cn_tedu_v1.userv1.pojo.dto.EmailDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.dto.SecurityDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.dto.UserRegDTO;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.Security;
import cn.tedu.cn_tedu_v1.userv1.pojo.entiy.User;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.EmailForGetVO;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserLoginResultVO;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserVO;
import cn.tedu.cn_tedu_v1.userv1.redis.IRedisCode;
import cn.tedu.cn_tedu_v1.userv1.response.ResultVO;
import cn.tedu.cn_tedu_v1.userv1.response.StatusCode;
import cn.tedu.cn_tedu_v1.userv1.security.CustomUserDetails;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 处理用户登录注册页面业务流程,检查登录状态
 * @author bmy
 *
 */
@RestController
@RequestMapping("/v1/users/")
@Slf4j
public class UserController {

    //static AtomicInteger times = new AtomicInteger(3);
    static AtomicInteger verification = new AtomicInteger(3);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${cn-tedu.jwt.duration-in-minute}")
    public Integer durationInMinute;

    @Value("${cn-tedu.jwt.secret-key}")
    public String securityKey;


    /**
     * 发送邮件功能
     *
     * @param email  接受验证码邮箱
     * @param httpSession 服务器缓存
     * @return 响应结果
     */
    @Autowired
    private IRedisCode redisCode;
    @GetMapping("send")
    public ResultVO send(@RequestParam("email") String email) {
        log.debug("email:{}",email);
        //生成四位随机验证码
        Integer code = new Random().nextInt(8999) + 1000;
        log.debug("验证码:{}",code);
        //用于创建简单的邮件消息。通过SimpleMailMessage对象，
        // 你可以设置邮件的发送者、接收者、主题、正文等信息。
        SimpleMailMessage message = new SimpleMailMessage();
        //主题
        message.setSubject("验证码验证");
        //正文
        message.setText("验证码:" + code);
        //接受邮箱
        message.setTo(email);
        //发送者邮箱
        message.setFrom("1129729148@qq.com");
        //发送
        javaMailSender.send(message);
        //验证码缓存redis两分钟
        redisCode.saveEmailCode(email,code);
//        httpSession.setAttribute("code", code);
//        httpSession.setMaxInactiveInterval(120);//2分钟
        return new ResultVO(StatusCode.SUCCESS);
    }

    /**
     * 注册功能
     * @param userRegDTO 用户输入内容
     * @param httpSession  服务器缓存
     * @return
     */
    @PostMapping("reg")
    public ResultVO insert(@RequestBody UserRegDTO userRegDTO, HttpSession httpSession) {
        System.out.println("userRegDTO = " + userRegDTO.getCode());
        //判断邮箱是否存在
        System.out.println("userRegDTO = " + userRegDTO );
        if (userMapper.selectByEmail(userRegDTO.getEmail()) != 0) {
            return new ResultVO(StatusCode.EMAIL_EXISTS_ERROR);
        }
        //httpSession.getAttribute("code")
        //判断验证码与缓存的验证码是否一致
        if (!userRegDTO.getCode().equals(String.valueOf(redisCode.getEmailCode(userRegDTO.getEmail())))) {
            return new ResultVO(StatusCode.VERIFICATION_ERROR);
        }

        System.out.println("userRegDTO = " + userRegDTO);

        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        if (userVO != null) {//代表用户名已存在
            return new ResultVO(StatusCode.REPEAT_USER);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user);
        user.setCreateTime(new Date());
        //生成用户ID
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1);
        user.setUserId(idGenerator.nextId());

        //初始赋权全部赋权用户权限
        user.setAdmin("user");

        //让密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userMapper.insert(user);

        System.out.println("userRegDTO = " + userRegDTO);

        //密保问题答案插入
        Long userId = user.getId();
        Security security = new Security();
        BeanUtils.copyProperties(userRegDTO, security);
        security.setUserId(userId);
        System.out.println(security);
        userMapper.insertSecurity(security);
        return new ResultVO(StatusCode.SUCCESS);


    }

    @Autowired
    private AuthenticationManager manager;

    /**
     * 登录功能
     * @param userRegDTO 接受用户输入的账号密码
     * @return
     */
    @PostMapping("login")
    public ResultVO login(@RequestBody UserRegDTO userRegDTO) {
        log.debug("登录请求传入的参数{}",userRegDTO);
        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUsername());
        log.debug("根据用户名查询到的userVO:{}",userVO);
        Authentication result = manager.authenticate(new UsernamePasswordAuthenticationToken(
                userRegDTO.getUsername(), userRegDTO.getPassword()));
        log.debug("验证用户登录成功返回来的登陆结果{}",result);

        Object principal = result.getPrincipal();
        //这个就是UserDetailServiceImpl类中返回的UserDetails对象数据
        log.debug("从认证结果中获取到当事人{}",principal);
        CustomUserDetails customUserDetails = (CustomUserDetails) principal;
        Long id = customUserDetails.getId();
        log.debug("从认证结果中的当事人中获取到的ID:{}", id);

        String username = customUserDetails.getUsername();
        log.debug("从认证结果中的当事人中获取到的昵称:{}", username);

        Collection<GrantedAuthority> authorities = customUserDetails.getAuthorities();
        log.debug("从认证结果中的当事人中获取到的权限:{}", authorities);

        String authoritiesJsonString = JSON.toJSONString(authorities);
        log.debug("将权限列表对象转换为JSON格式的字符串：{}", authoritiesJsonString);
        Date date = new Date(System.currentTimeMillis() + 1L * 60 * 1000 * durationInMinute);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("username", username);
        claims.put("authoritiesJsonString", authoritiesJsonString);
        String jwt = Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256, securityKey)
                .compact();

        UserLoginResultVO userLoginResultVO = new UserLoginResultVO()
                .setId(id)
                .setUsername(username)
                .setAdmin(authorities)
                .setToken(jwt);
        return new ResultVO(StatusCode.SUCCESS,userLoginResultVO);



        //将认证结果保存到Security上下文中   让Security框架记住登录状态
//        SecurityContextHolder.getContext().setAuthentication(result);
       // return new ResultVO(result.getPrincipal());
    }

    /**
     * 忘记密码密保修改密码业务逻辑
     * @param securityDTO 接受用户输入数据
     * @return 响应对象
     */
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
                //
                verification.set(3);
                //加密修改好的密码
                securityDTO.setPassword(passwordEncoder.encode(securityDTO.getPassword()));
                securityMapper.passwordUpdate(securityDTO);
                return new ResultVO(StatusCode.SUCCESS);
            }
            return ForgetThePassword(verification.decrementAndGet());
        }
        return ForgetThePassword(verification.decrementAndGet());
    }


    @Autowired
    private EmailForGetMapper emailForGetMapper;

    /**
     * 忘记密码邮箱修改密码业务逻辑
     * @param emailDTO 用户输入的邮箱
     * @param session 服务器缓存
     * @return 给前端返回响应对象
     */
    @PostMapping("forget-email")
    public ResultVO forgetEmail(@RequestBody EmailDTO emailDTO) {
        System.out.println("emailDTO = " + emailDTO);
        EmailForGetVO emailForGetVO = emailForGetMapper.selectByEmail(emailDTO.getEmail());
        if (emailForGetVO == null) {
            return new ResultVO(StatusCode.NOT_EMAIL_ERROR);
        }
        //session.getAttribute("code")
        //判断验证码与缓存的验证码是否一致
        if (!emailDTO.getCode().equals(String.valueOf(redisCode.getEmailCode(emailDTO.getEmail())))) {
            return new ResultVO(StatusCode.VERIFICATION_ERROR);
        }

        //加密密码
        emailDTO.setPassword(passwordEncoder.encode(emailDTO.getPassword()));
        emailForGetMapper.updateByEmail(emailDTO);

        sendUserName(emailForGetVO.getEmail(),emailForGetVO.getUserName());

        return new ResultVO(StatusCode.SUCCESS,emailForGetVO);
    }




    //登陆状态检查--检查用户进入网站后是否登录--展示首页页面不同
   /* @GetMapping("currentUser")
    public UserVO currentUser(HttpSession session) {
        UserVO userVO = (UserVO) session.getAttribute("user");
        return userVO;
    }*/

    /**
     * 忘记密码验证成功后,发送邮件方法
     * @param toEmail 收件邮箱
     * @param userName 用户名
     */
    public void sendUserName(String toEmail,String userName) {
        System.out.println("toEmail = " + toEmail + ", userName = " + userName);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("用户名发送");
        message.setText("用户名:" + userName +"请妥善保存");
        message.setTo(toEmail);
        message.setFrom("1129729148@qq.com");


        javaMailSender.send(message);

    }

    //退出登录
    @GetMapping("logout")
    public void logout() {
        //从Security框架中删除认证数据
        SecurityContextHolder.clearContext();
    }

    /**
     * 忘记密码判断密选择及答案是否正确
     * @param verification 次数
     * @return 响应对象
     */
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
