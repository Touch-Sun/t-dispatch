package io.github.touchsun.tdispatch.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 执行引擎
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "engine")
public class Engine extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 1104188021198652550L;

    /**
     * 应用名称
     */
    private String appName;
    /**
     * 执行引擎名称
     */
    private String title;
    /**
     * 注册类型：0-自动 1-手动
     */
    private String type;
    /**
     * 执行引擎机器地址，逗号分割
     */
    private String addressList;

}
