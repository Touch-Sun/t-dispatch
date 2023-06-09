package io.github.touchsun.tdispatch.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import io.github.touchsun.tdispatch.core.util.EmptyUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    private Integer type;
    /**
     * 执行引擎机器地址，逗号分割
     */
    private String addressList;

    /**
     * 执行引擎机器地址List
     * - 此处返回只读的List不允许调用方修改执行引擎地址
     * 
     * @return 执行引擎机器地址List
     */
    public List<String> listOfAddressList() {
        List<String> result = new ArrayList<>(256);
        if (EmptyUtil.isNotEmpty(addressList) && EmptyUtil.isNotEmpty(addressList.trim())) {
            result = Collections.unmodifiableList(
                    Arrays.stream(addressList.split(","))
                            .map(String::trim)
                            .filter(s -> !s.isEmpty())
                            .collect(Collectors.toList()));
        }
        return result;
    }
}
