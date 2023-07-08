package cn.tedu.cn_tedu_v1.front.pojo.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class AdvertiseVO implements Serializable {
    private Long id;
    private String name;
    private String url;
}
