package cn.tedu.cn_tedu_v1.common.ex;



import cn.tedu.cn_tedu_v1.common.web.ServiceCode;
import lombok.Getter;


/**
 * 业务异常
 *
 * @author java@tedu.cn
 * @version 1.0
 */

public class ServiceException extends RuntimeException {

    @Getter
    private ServiceCode serviceCode;

    public ServiceException(ServiceCode serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

}
