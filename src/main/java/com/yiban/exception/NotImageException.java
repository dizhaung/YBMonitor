package com.yiban.exception;

/**
 * 捕获发送网络请求时发生异常
 */
public class NotImageException extends Exception {

    public NotImageException(String message) {
        super(message);
    }

    public NotImageException(String message, Throwable cause) {
        super(message, cause);
    }
}
