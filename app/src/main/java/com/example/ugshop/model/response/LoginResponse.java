package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.network.ErrorResponse;

public class LoginResponse extends ResponseEntity {
    ErrorResponse error;
    boolean loginStatus;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return loginStatus;
    }

    public void setSuccess(boolean success) {
        this.loginStatus = success;
    }
}
