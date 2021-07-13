package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.network.ErrorResponse;

public class LoginResponse extends ResponseEntity {
    ErrorResponse errorResponse;
    boolean success;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
