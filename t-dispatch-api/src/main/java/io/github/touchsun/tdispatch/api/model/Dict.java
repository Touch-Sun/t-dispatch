package io.github.touchsun.tdispatch.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 字典
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "dict")
public class Dict extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = -2238449143901381580L;
    
    private String key;

    private String value;
    
    private String type;
}
