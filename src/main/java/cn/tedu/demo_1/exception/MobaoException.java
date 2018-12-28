package cn.tedu.demo_1.exception;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 自定义异常
 */
public class MobaoException extends RuntimeException{
    public MobaoException() {
    }

    public MobaoException(String message) {
        super(message);
    }

    public MobaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MobaoException(Throwable cause) {
        super(cause);
    }

    public MobaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
