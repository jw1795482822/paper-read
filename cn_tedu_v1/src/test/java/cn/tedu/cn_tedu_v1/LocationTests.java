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
        String Ip = "111.206.214.37";
        locationService.getLocation(Ip);
    }
}