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

    public static <T> Result<T> reply(ResultStatusEnum ResultStatusEnum) {
        Result<T> result = reply();
        result.setCode(ResultStatusEnum.getCode());
        result.setMessage(ResultStatusEnum.getMessage());
        return result;
    }

    public static <T> Result<T> reply(ResultStatusEnum ResultStatusEnum, T data) {
        Result<T> result = reply();
        result.setCode(ResultStatusEnum.getCode());
        result.setMessage(ResultStatusEnum.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return reply(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data) {
        return reply(ResultStatusEnum.SUCCESS.getCode(), data, ResultStatusEnum.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data, String message) {
        return reply(ResultStatusEnum.SUCCESS.getCode(), data, message);
    }

    public static <T> Result<T> failed() {
        return reply(ResultStatusEnum.FAILED.getCode(), ResultStatusEnum.FAILED.getMessage());
    }

    public static <T> Result<T> failed(String message) {
        return reply(ResultStatusEnum.FAILED.getCode(), message);
    }

    public static <T> Result<T> unauthorized() {
        return reply(ResultStatusEnum.AUTHENTICATION_FAILED.getCode(), ResultStatusEnum.AUTHENTICATION_FAILED.getMessage());
    }

    public static <T> Result<T> unauthorized(T data) {
        return reply(ResultStatusEnum.AUTHENTICATION_FAILED.getCode(), data, ResultStatusEnum.AUTHENTICATION_FAILED.getMessage());
    }

    public static <T> Result<T> health() {
        return reply(ResultStatusEnum.APP_HEALTH.getCode(), ResultStatusEnum.APP_HEALTH.getMessage());
    }

    public static <T> Result<T> health(T data) {
        return reply(ResultStatusEnum.APP_HEALTH.getCode(), data, ResultStatusEnum.APP_HEALTH.getMessage());
    }

    public static <T> Result<T> unPermission() {
        return reply(ResultStatusEnum.PERMISSION_FAILED.getCode(), ResultStatusEnum.PERMISSION_FAILED.getMessage());
    }


}
