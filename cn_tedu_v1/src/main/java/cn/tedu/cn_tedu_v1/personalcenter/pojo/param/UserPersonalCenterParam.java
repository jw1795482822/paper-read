package cn.tedu.cn_tedu_v1.personalcenter.pojo.param;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * wsk
 * 修改个人信息
 */
@Data
public class UserPersonalCenterParam {
    /**
     * 昵称
     */
    @NotNull(message = "请提交用户昵称")
    @ApiModelProperty(value = "用户昵称", required = true)
    private String nickName;
    /**
     * 性别
     */
    @Pattern(regexp = "^(男|女)$" , message = "请输入 '男' 或 '女' ")
    private String gender;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 身份证号码
     */
    private Long idnumber;
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用于存储雪花算法生成唯一标识
     */
    private Long userId;
    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
