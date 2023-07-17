package cn.tedu.cn_tedu_v1;

import cn.tedu.cn_tedu_v1.location.service.ILocationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * Author = bianmy
 * DATE = 2023/7/7 20:11
 */
@Slf4j
@SpringBootTest
public class LocationTests {
    @Autowired
    ILocationService locationService;

    @Test
    void xx() throws IOException {
        /*省市	中国移动DNS服务器IP大全	中国移动DNS服务器IP大全
        中国移动IPv6DNS	2409:8088::a	2409:8088::b
        安徽移动DNS	211.138.180.2	211.138.180.3
        山东移动DNS	218.201.96.130	211.137.191.26
        山东移动DNS	218.201.124.18	218.201.124.19*/
        String Ip = "218.201.96.130";
        locationService.getLocation(Ip);
    }
}