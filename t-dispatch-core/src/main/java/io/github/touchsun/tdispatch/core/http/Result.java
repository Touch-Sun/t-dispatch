package io.github.touchsun.tdispatch.core.http;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回
 * 
 * @author lee
 * @since 2023/6/1 21:28
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5193422085379903156L;

    /**
     * 数据
     */
    protected T data;

    /**
     * 状态码
     */
    protected int code;

    /**
     * 信息
     */
    protected String message;

    private Result() {
        super();
    }

    public static <T> Result<T> reply() {
        return new Result<>();
    }

    public static <T> Result<T> reply(int code) {
        Result<T> result = reply();
        result.setCode(code);
        return result;
    }

    public static <T> Result<T> reply(int code, String message) {
        Result<T> result = reply();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> reply(int code, T data, String message) {
        Result<T> result = reply();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> reply(StatusEnum StatusEnum) {
        Result<T> result = reply();
        result.setCode(StatusEnum.getCode());
        result.setMessage(StatusEnum.getMessage());
        return result;
    }

    public static <T> Result<T> reply(StatusEnum StatusEnum, T data) {
        Result<T> result = reply();
        result.setCode(StatusEnum.getCode());
        result.setMessage(StatusEnum.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return reply(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data) {
        return reply(StatusEnum.SUCCESS.getCode(), data, StatusEnum.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data, String message) {
        return reply(StatusEnum.SUCCESS.getCode(), data, message);
    }

    public static <T> Result<T> failed() {
        return reply(StatusEnum.FAILED.getCode(), StatusEnum.FAILED.getMessage());
    }

    public static <T> Result<T> failed(String message) {
        return reply(StatusEnum.FAILED.getCode(), message);
    }

    public static <T> Result<T> unauthorized() {
        return reply(StatusEnum.AUTHENTICATION_FAILED.getCode(), StatusEnum.AUTHENTICATION_FAILED.getMessage());
    }

    public static <T> Result<T> unauthorized(T data) {
        return reply(StatusEnum.AUTHENTICATION_FAILED.getCode(), data, StatusEnum.AUTHENTICATION_FAILED.getMessage());
    }

    public static <T> Result<T> health() {
        return reply(StatusEnum.APP_HEALTH.getCode(), StatusEnum.APP_HEALTH.getMessage());
    }

    public static <T> Result<T> health(T data) {
        return reply(StatusEnum.APP_HEALTH.getCode(), data, StatusEnum.APP_HEALTH.getMessage());
    }

    public static <T> Result<T> unPermission() {
        return reply(StatusEnum.PERMISSION_FAILED.getCode(), StatusEnum.PERMISSION_FAILED.getMessage());
    }


}
