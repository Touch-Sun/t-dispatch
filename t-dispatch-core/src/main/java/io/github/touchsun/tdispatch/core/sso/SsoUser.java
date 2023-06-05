package io.github.touchsun.tdispatch.core.sso;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 登录用户
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
public class SsoUser extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 4860310301120611797L;

    private Integer id;
    
    private String phone;

    private String email;

    private String userName;

    private String type;

    private LocalDate authorizeStartDate;

    private LocalDate authorizeEndDate;

    private String status;

    private String menuList;
}
