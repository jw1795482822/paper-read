package cn.tedu.cn_tedu_v1.location.service;


import cn.tedu.cn_tedu_v1.location.pojo.vo.LocationResponse;

import java.io.IOException;

/**
 * Author = bianmy
 * DATE = 2023/7/7 18:30
 */
public interface ILocationService {
    LocationResponse getLocation(String IP) throws IOException;
}