package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.network.ErrorResponse;

public class AddAddressResponse extends ResponseEntity {
    private boolean successfullyAddAddress;
    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public boolean isSuccessfullyAddAddress() {
        return successfullyAddAddress;
    }

    public void setSuccessfullyAddAddress(boolean successfullyAddAddress) {
        this.successfullyAddAddress = successfullyAddAddress;
    }
}
