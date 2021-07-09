package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;

public class RemoveAddressResponse extends ResponseEntity {

    private boolean successfullyRemoveAddress;

    public boolean isSuccessfullyRemoveAddress() {
        return successfullyRemoveAddress;
    }

    public void setSuccessfullyRemoveAddress(boolean successfullyRemoveAddress) {
        this.successfullyRemoveAddress = successfullyRemoveAddress;
    }
}
