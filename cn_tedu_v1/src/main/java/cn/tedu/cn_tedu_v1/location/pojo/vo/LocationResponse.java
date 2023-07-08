package cn.tedu.cn_tedu_v1.location.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

/**
 *
 * 接受百度地图定位定位返回数据
 * Author = bianmy
 * DATE = 2023/7/7 19:18
 */

@Data
public class LocationResponse {

    private String address;
    private Map<String,Object> content;
    private int status;

    public LocationResponse(String address, Map<String, Object> content, int status) {
        this.address = address;
        this.content = content;
        this.status = status;
    }
}

