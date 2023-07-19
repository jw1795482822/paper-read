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
   @Pattern(regexp = "^[a-zA-Z\\u4e00-\\u9fa5]{2,10}$",
            message = "用户昵称必须是2~10长度的字符组成，且不允许使用标点符号")
    @ApiModelProperty(value = "用户昵称", required = true)
    private String nickName;
    /**
     * 性别
     */
    @Pattern(regexp = "^(男|女)$" , message = "滚!")
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
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
