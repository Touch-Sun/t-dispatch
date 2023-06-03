package io.github.touchsun.tdispatch.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 用户
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"password"})
@TableName(value = "user")
public class User extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 4860310301120611797L;
    
    private String phone;

    private String email;

    private String password;

    private String userName;

    private String type;

    private LocalDate authorizeStartDate;

    private LocalDate authorizeEndDate;

    private String status;

    private String menuList;
}
