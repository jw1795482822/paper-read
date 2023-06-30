package cn.tedu.cn_tedu_v1.userv1.security;



import cn.tedu.cn_tedu_v1.userv1.mapper.UserMapper;
import cn.tedu.cn_tedu_v1.userv1.pojo.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired(required = false)
    UserMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过用户输入的用户名从数据库中查询信息
        UserVO userVO = mapper.selectByUserName(username);
        if (userVO==null){
            return null;//代表用户名不存在,此时会抛出异常
        }

        String role = userVO.getAdmin();
      // 如果用户输入的密码和数据库中查询到的密码不一致 则会抛出异常
        List<GrantedAuthority> list =
                AuthorityUtils.createAuthorityList(role);
        //创建自定义的UserDetails 并把后期需要用到的id和昵称保存到里面
        CustomUserDetails cud = new CustomUserDetails(
                userVO.getId(), userVO.getNickname(),username, userVO.getPassword(),list);
        log.debug("即将向Spring security框架返回UserDetails类型结果数据{}",cud);
        log.debug("接下来接下来，将由Spring Security框架自动验证用户状态、密码等，以判断是否可以成功登录！");
        return cud;
    }
}
