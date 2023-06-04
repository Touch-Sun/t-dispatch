package io.github.touchsun.tdispatch.core.http;

import lombok.Getter;

/**
 * 处理状态
 *
 * @author lee
 * @since 2023/6/1 21:28
 */
public enum StatusEnum {

    /**
     * 操作成功
     */
    SUCCESS(200, "处理成功"),
    /**
     * 操作失败
     */
    FAILED(500, "服务异常"),
    /**
     * 登录认证失败
     */
    AUTHENTICATION_FAILED(403, "认证失败"),
    /**
     * 权限认证失败
     */
    PERMISSION_FAILED(405, "授权失败"),
    /**
     * 应用健康检查
     */
    APP_HEALTH(203, "状况良好");

    @Getter
    private final int code;

    @Getter
    private final String message;

    StatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
