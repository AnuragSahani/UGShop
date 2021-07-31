package com.example.ugshop.model.response;

import com.example.ugshop.network.ErrorResponse;

public class VerifyOtpResponse {

    private boolean verified;
    private ErrorResponse error;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        verified = verified;
    }

    public ErrorResponse getErrorResponse() {
        return error;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.error = errorResponse;
    }
}
