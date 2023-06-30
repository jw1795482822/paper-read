package cn.tedu.cn_tedu_v1.core.exception;


import cn.tedu.cn_tedu_v1.userv1.response.ResultVO;
import cn.tedu.cn_tedu_v1.userv1.response.StatusCode;


import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




/**
 * RestControllerAdvice 描述的类型为一个全局异常处理对象类型,
 * 当某个Controller方法中出现了异常，此时在Controller类内部，又没有定义对应的
 * 异常处理方法(使用ExcetpionHandler注解描述的方法)，系统底层就会查找有没有定义全局异常处理对象。
 * 这个全局异常处理对象中有没有定义对应的异常处理方法，假如有就调用此方法处理异常。
 */

@Slf4j //lombok提供的日志注解，在代码层面会为我们提供一个org.slf4j.Logger对象
@RestControllerAdvice //=@ControllerAdvice+@ResponseBody
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
        log.info("创建异常处理器GlobalExceptionHandler");
    }


    /**
     * 用户名或密码错误抛出的异常
     */
    @ExceptionHandler({InternalAuthenticationServiceException.class,
            BadCredentialsException.class})
    public ResultVO handleAuthenticationException(AuthenticationException e) {
        //判断当前异常是否属于用户名不存在异常
        if (e instanceof InternalAuthenticationServiceException) {
            log.warn("用户名不存在!");
            return new ResultVO(StatusCode.USER_NOT_EXIST_ERROR);
        }
        log.warn("密码错误!");
        return new ResultVO(StatusCode.PASSWORD_ERROR);
    }





}
