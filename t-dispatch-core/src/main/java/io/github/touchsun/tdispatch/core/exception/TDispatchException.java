package io.github.touchsun.tdispatch.core.exception;

/**
 * t-dispatch 异常
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
public class TDispatchException extends RuntimeException {

    public TDispatchException() {
        
    }

    public TDispatchException(String message) {
        super(message);
    }
}
