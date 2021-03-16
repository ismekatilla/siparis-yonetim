package com.uniyaz.common.exceptions;

/**
 * Created by AKARTAL on 16.3.2021.
 */
public class SyException extends RuntimeException {

    private EnumExceptionType exceptionType = EnumExceptionType.ERROR;

    public SyException(String message) {
        super(message);
    }

    public SyException(String message, EnumExceptionType exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public enum EnumExceptionType {
        ERROR,
        WARNING
    }

    public EnumExceptionType getExceptionType() {
        return exceptionType;
    }
}
