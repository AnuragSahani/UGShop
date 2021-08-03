package com.example.ugshop.model.response;

import com.example.ugshop.network.ErrorResponse;

public class ForgetPasswordResponse {
    private ErrorResponse error;
    private boolean send;

    public ErrorResponse getError() {
        return error;
    }
    public void setError(ErrorResponse error) {
        this.error = error;
    }
    public boolean isSend() {
        return send;
    }
    public void setSend(boolean send) {
        this.send = send;
    }
}
