package com.yiban.exception;

/**
 * ���񱾵���Ϣ��ȡʧ�ܵ��쳣
 */
public class UnknownInfoException extends SystemRunTimeException {
    public UnknownInfoException(String message) {
        super(message);
    }

    public UnknownInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
