package cn.tedu.cn_tedu_v1.userv1.pojo.entiy;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Author = bianmy
 * DATE = 2023/5/19 21:35
 */

@Data
public class Security {
    private Long id;
    private String question;
    private String answer;
    private Long userId;
}