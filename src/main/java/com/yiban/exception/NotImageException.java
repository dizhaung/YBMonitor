package com.yiban.exception;

/**
 * ��������������ʱ�����쳣
 */
public class NotImageException extends Exception {

    public NotImageException(String message) {
        super(message);
    }

    public NotImageException(String message, Throwable cause) {
        super(message, cause);
    }
}
