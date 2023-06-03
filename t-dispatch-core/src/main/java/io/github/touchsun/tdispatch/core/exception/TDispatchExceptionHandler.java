package io.github.touchsun.tdispatch.core.exception;

import io.github.touchsun.tdispatch.core.http.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@ControllerAdvice
@Component
@Slf4j
public class TDispatchExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> appInternalExceptionHandle(Exception e) {
        log.error("服务内部异常,异常信息: {}", e.toString(), e);
        e.printStackTrace();
        return Result.failed(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = TDispatchException.class)
    @ResponseBody
    public Result<String> activeThrowExceptionHandle(TDispatchException e) {
        log.warn("主动抛出异常, 异常信息: {}", e.toString(), e);
        return Result.failed(e.getMessage());
    }
}
