package cn.tedu.cn_tedu_v1.core.filter;



import cn.tedu.cn_tedu_v1.common.consts.HttpConsts;
import cn.tedu.cn_tedu_v1.common.security.CurrentPrincipal;
import cn.tedu.cn_tedu_v1.userv1.response.ResultVO;
import cn.tedu.cn_tedu_v1.userv1.response.StatusCode;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static cn.tedu.cn_tedu_v1.common.consts.HttpConsts.HEADER_AUTHORIZATION;

/**
 * <p>处理JWT的过滤器</p>
 *
 * <p>此过滤器的主要作用：</p>
 * <ul>
 *     <li>尝试接收客户端的请求中携带的JWT数据</li>
 *     <li>尝试解析JWT数据</li>
 *     <li>将解析得到的用户数据创建为Authentication对象，并存入到SecurityContext中</li>
 * </ul>
 *
 * @author java@tedu.cn
 * @version 1.0
 */
@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter implements HttpConsts {

    @Value("${cn-tedu.jwt.secret-key}")
    private String secretKey;

    /**
     * JWT最小长度值
     */
    public static final int JWT_MIN_LENGTH = 113;

    public JwtAuthorizationFilter() {
        log.info("创建过滤器对象：JwtAuthorizationFilter");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug("处理JWT的过滤器开始处理当前请求……");
        // 尝试接收客户端的请求中携带的JWT数据
        // 业内惯用的做法是：客户端会将JWT放在请求头中名为Authorization的属性中
        String jwt = request.getHeader(HEADER_AUTHORIZATION);
        log.debug("客户端携带的JWT：{}", jwt);

        // 判断JWT的基本有效性（没有必要尝试解析格式明显错误的JWT数据）
        if (!StringUtils.hasText(jwt) || jwt.length() < JWT_MIN_LENGTH) {
            // 对于无效的JWT，应该直接放行
            log.warn("当前请求中，客户端没有携带有效的JWT，将放行");
            filterChain.doFilter(request, response);
            return;
        }

        // 尝试解析JWT数据
        log.debug("尝试解析JWT数据……");
        response.setContentType("application/json; charset=utf-8");
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.warn("解析JWT时出现异常：ExpiredJwtException");
            ResultVO resultVO = new ResultVO(StatusCode.ERR_JWT_EXPIRED);
            PrintWriter writer = response.getWriter();
            writer.println(JSON.toJSONString(resultVO));
            writer.close();

        } catch (SignatureException e) {
            log.warn("解析JWT时出现异常：SignatureException");
            ResultVO resultVO = new ResultVO(StatusCode.ERR_JWT_SIGNATURE);
            PrintWriter writer = response.getWriter();
            writer.println(JSON.toJSONString(resultVO));
            writer.close();

        } catch (MalformedJwtException e) {
            log.warn("解析JWT时出现异常：MalformedJwtException");
            ResultVO resultVO = new ResultVO(StatusCode.ERR_JWT_MALFORMED);
            PrintWriter writer = response.getWriter();
            writer.println(JSON.toJSONString(resultVO));
            writer.close();

        } catch (Throwable e) {
            log.warn("解析JWT时出现异常：{}", e);
            ResultVO resultVO = new ResultVO(StatusCode.ERROR);
            PrintWriter writer = response.getWriter();
            writer.println(JSON.toJSONString(resultVO));
            writer.close();
        }

        // 从解析结果中获取用户的信息
        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);
        String authoritiesJsonString = claims.get("authoritiesJsonString", String.class);
        log.debug("JWT中的用户id = {}", id);
        log.debug("JWT中的用户名 = {}", username);
        log.debug("JWT中的用户权限列表 = {}", authoritiesJsonString);

        // 将解析得到的用户数据创建为Authentication对象
        CurrentPrincipal principal = new CurrentPrincipal(); // 当事人
        principal.setId(id);
        principal.setUsername(username);
        Object credentials = null; // 凭证：无需凭证
        List<SimpleGrantedAuthority> authorities
                = JSON.parseArray(authoritiesJsonString, SimpleGrantedAuthority.class);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal, credentials, authorities);

        // 将Authentication对象存入到SecurityContext中
        log.debug("authentication存储信息为{}", authentication);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        // 过滤器链继续执行，即：放行
        filterChain.doFilter(request, response);
    }

}