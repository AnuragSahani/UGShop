package com.example.ugshop.model.response;

import com.example.ugshop.network.ErrorResponse;

public class GenerateOtpResponse {

    private ErrorResponse errorResponse;
    private  boolean isGenerated;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public boolean isGenerated() {
        return isGenerated;
    }

    public void setGenerated(boolean generated) {
        isGenerated = generated;
    }
}
