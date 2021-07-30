package com.example.ugshop.model.response;

import com.example.ugshop.network.ErrorResponse;

public class VerifyOtpResponse {

    private boolean isVerified;
    private ErrorResponse errorResponse;

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
