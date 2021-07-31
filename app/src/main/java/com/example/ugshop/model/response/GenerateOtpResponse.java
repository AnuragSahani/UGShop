package com.example.ugshop.model.response;

import com.example.ugshop.network.ErrorResponse;

public class GenerateOtpResponse {

    private ErrorResponse error;
    private  boolean sent;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
