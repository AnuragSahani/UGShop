package com.example.ugshop.network;

public class ErrorResponse {
    private String errorMessage;
    private int errorCode;

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
//TODO: make ErrorResponse class var name is appError in all response classes.
