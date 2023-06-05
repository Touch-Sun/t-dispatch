package io.github.touchsun.tdispatch.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 注册表
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "registry")
public class Registry extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = -2238449143901381580L;

    /**
     * 键(一般为执行引擎的应用名称)
     */
    private String key;

    /**
     * 值(一般为执行引擎的服务地址)
     */
    private String value;
}
