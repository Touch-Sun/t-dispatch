package io.github.touchsun.tdispatch.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

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
