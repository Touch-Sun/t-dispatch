package io.github.touchsun.tdispatch.api.enums;

import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import lombok.Getter;

/**
 * 执行引擎注册类型
 *
 * @author lee
 * @since 2023/6/5 8:30
 */
public enum RegisterType {

    /**
     * 自动注册
     */
    AUTO(ConstantNumber.ZERO, "自动"),
    /**
     * 手动注册
     */
    MANUAL(ConstantNumber.ONE, "手动");
    
    @Getter
    private final Integer code;
    
    @Getter
    private final String name;

    RegisterType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
