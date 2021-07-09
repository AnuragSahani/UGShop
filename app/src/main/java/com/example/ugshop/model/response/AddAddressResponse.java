package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;

public class AddAddressResponse extends ResponseEntity {
    private boolean successfullyAddAddress;

    public boolean isSuccessfullyAddAddress() {
        return successfullyAddAddress;
    }

    public void setSuccessfullyAddAddress(boolean successfullyAddAddress) {
        this.successfullyAddAddress = successfullyAddAddress;
    }
}
