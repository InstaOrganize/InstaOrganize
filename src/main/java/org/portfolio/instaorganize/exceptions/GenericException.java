package org.portfolio.instaorganize.exceptions;

public class GenericException extends RuntimeException{
    private int errorCode;
    private String message;

    public GenericException(int errorCode) {
        this.errorCode = errorCode;
    }
    public GenericException(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
