package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.network.ErrorResponse;

public class SignupResponse extends ResponseEntity {

    private ErrorResponse error;
    private boolean signed;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean isSigned) {
        this.signed = isSigned;
    }
}
