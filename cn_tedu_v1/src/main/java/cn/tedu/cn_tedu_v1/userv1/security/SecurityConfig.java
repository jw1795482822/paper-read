package cn.tedu.cn_tedu_v1.userv1.security;

import cn.tedu.cn_tedu_v1.core.filter.JwtAuthorizationFilter;
import cn.tedu.cn_tedu_v1.userv1.response.ResultVO;
import cn.tedu.cn_tedu_v1.userv1.response.StatusCode;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法授权的检测
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;

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

        // 配置Security框架不使用Session
        // SessionCreationPolicy.NEVER：从不主动创建Session，但是，Session存在的话，会自动使用
        // SessionCreationPolicy.STATELESS：无状态，无论是否存在Session，都不使用
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 允许跨域访问，本质上是启用了Security框架自带的CorsFilter
        http.cors();

        // 将自定义的解析JWT的过滤器添加到Security框架的过滤器链中
        // 必须添加在检查SecurityContext的Authentication之前，具体位置并不严格要求

        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        // 处理“无认证信息却访问需要认证的资源时”的响应
        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                log.warn("认证错误{}",e);
                response.setContentType("application/json; charset=utf-8");
                ResultVO resultVO = new ResultVO(StatusCode.ERROR_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                out.println(JSON.toJSONString(resultVO));
                out.close();
            }
        });
        String[] urls = {
                "/favicon.ico",
                "/doc.html",
                "/**/*.css",
                "/**/*.js",
                "/swagger-resources",
                "/v2/api-docs",
                "/resources/**", // 静态资源文件夹，通常是上传的文件，请与配置文件中的"tea-store.upload.base-dir-name"一致
                "/v1/users/login",
                "/v1/users/reg",
                "v1/users/send",
                "v1/users/forget",
                "v1/users/forget-email"
        };

        // 配置请求授权
        // 如果某个请求被多次配置，按照“第一匹配原则”处理
        // 应该将精确的配置写在前面，将较模糊的配置写在后面
        http.authorizeRequests()
                .mvcMatchers(urls) // 匹配某些请求
                .permitAll() // 许可，即不需要通过认证就可以访问
                .anyRequest() // 任何请求，从执行效果来看，也可以视为：除了以上配置过的以外的其它请求
                .authenticated(); // 需要通过认证才可以访问


        //当访问需要登录认证才能访问的资源时, 没有登录的时跳转到登录页面
//        http.formLogin().loginPage("http://localhost:9098//login");//弹出登录页面


        // 定义哪些 URL 需要被保护
        //目前用户权限只有user admin bookadmin,注册时默认赋值user权限
        //因为hasRole代码里面底层会补全一个ROLE_  所以再给账号赋权时应加上ROLE_admin
       /* http.authorizeRequests()
                .antMatchers("/index.html").permitAll() // /public/** URL 可以被所有人访问
                .antMatchers("http://localhost:9090/home").hasRole("admin") // /admin/** URL 只能被拥有 ADMIN 角色的用户访问
                .antMatchers("http://localhost:9090/bookadmin").hasAnyAuthority("bookadmin")
                .anyRequest().authenticated() // 其他 URL 需要登录才能访问
                .and()
                .exceptionHandling().accessDeniedPage("/remind.html");//没有权限访问提醒页面*/


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
