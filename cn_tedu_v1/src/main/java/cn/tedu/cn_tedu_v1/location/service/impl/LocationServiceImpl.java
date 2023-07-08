package cn.tedu.cn_tedu_v1.location.service.impl;


import cn.tedu.cn_tedu_v1.location.pojo.vo.LocationResponse;
import cn.tedu.cn_tedu_v1.location.service.ILocationService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;

/**
 * Author = bianmy
 * DATE = 2023/7/7 18:30
 */
@Slf4j
@Configuration
public class LocationServiceImpl implements ILocationService {



    @Override
    public LocationResponse getLocation(String IP) throws IOException {
        // 创建 HttpClient 实例
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //请求url路径
        //"https://api.map.baidu.com/location/ip?ip=111.206.214.37&coor=bd09ll&ak=您的AK"
        String url
                = "https://api.map.baidu.com/location/ip?ip=" + IP + "&coor=bd09ll&ak=lXttjj9VKB7ZwMZOR58xgpMEPPHdHli4";

        // 创建 HttpGet 请求
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        // 转换为字符串
        String json = EntityUtils.toString(entity);

        //JSON数据转LocationResponse对象
        LocationResponse locationResponse =
                JSON.parseObject(json, LocationResponse.class);

        log.info("JSON数据转换完的LocationResponse对象数据{}", locationResponse);

        return locationResponse;
    }
}