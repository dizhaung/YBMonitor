package com.yiban.exception;


/**
 * ��������ϵͳ�쳣
 */
public class SystemRunTimeException extends RuntimeException {
    public SystemRunTimeException(String message) {
        super(message);
    }

    public SystemRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
