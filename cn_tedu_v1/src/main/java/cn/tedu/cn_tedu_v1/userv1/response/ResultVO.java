package cn.tedu.cn_tedu_v1.userv1.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author = bianmy
 * DATE = 2023/5/19 23:32
 * 错误编码应答具体类
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    /**响应状态码(业务状态码)*/
    private int code;
    /**服务端要返回给客户端的消息(例如，密码不正确)*/
    private String misDescription;
    /**服务端要返回给客户端的具体数据(业务数据，比方说从数据库查询到的数据)*/
    private Object data;

    //构造方法: 返回对象 编码,编码内容,数据对应对象--VO类
    public ResultVO(Object data) {
        this.data = data;
        this.code=StatusCode.SUCCESS.getCode();
        this.misDescription=StatusCode.SUCCESS.getMisDescription();
    }
    //编码,编码内容
    public ResultVO(int code,String misDescription){
        this.code=code;
        this.misDescription=misDescription;
    }
    /**通过构造方法对属性初始化*/
    public ResultVO(StatusCode statusCode){
        this.code=statusCode.getCode();
        this.misDescription=statusCode.getMisDescription();
    }
    /**通过构造方法对象属性初始化*/
    public ResultVO(StatusCode statusCode,Object data){
        this(statusCode);
        this.data=data;
    }


}