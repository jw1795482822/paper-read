package cn.tedu.cn_tedu_v1.userv1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法授权的检测
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //配置密码加密的方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        //NoOpPasswordEncoder.getInstance()获取一个无加密的实例
//        return NoOpPasswordEncoder.getInstance();
        //返回此加密的编码器之后, 用户输入的密码会通过此编码器加密之后再和数据库里面的
        //密码进行比较
        return new BCryptPasswordEncoder();
    }

    @Bean  //添加此注解的目的是为了在Controller中自动装配
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //没有权限访问提醒页面
        http.exceptionHandling().accessDeniedPage("/remind.html");

        //当访问需要登录认证才能访问的资源时, 没有登录的时跳转到登录页面
        http.formLogin().loginPage("/login.html");//弹出登录页面


        // 定义哪些 URL 需要被保护
        //目前用户权限只有user admin bookadmin,注册时默认赋值user权限
        //因为hasRole代码里面底层会补全一个ROLE_  所以再给账号赋权时应加上ROLE_admin
        http.authorizeRequests()
                .antMatchers().permitAll() // /public/** URL 可以被所有人访问
                .antMatchers("/admin.html").hasRole("admin") // /admin/** URL 只能被拥有 ADMIN 角色的用户访问
                .antMatchers("/bookadmin.html").hasAnyAuthority("bookadmin");


        //设置黑名单(需要登录才可访问的资源)
//        String[] urls = {""};
//        http.authorizeHttpRequests()//对请求进行授权
//                .mvcMatchers(urls)   //匹配某些路径
//                .authenticated()     //  需要通过登录认证
//                .anyRequest()        //其它任意请求
//                .permitAll();        //直接放行,  即不需要登录也可以访问
        //关闭跨域攻击防御策略  否则所有post请求将失效
        http.csrf().disable();

    }
}
