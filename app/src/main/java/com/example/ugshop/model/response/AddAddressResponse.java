package com.example.ugshop.model.response;

import com.example.ugshop.model.common.AddressModel;

import java.util.ArrayList;
import java.util.List;

public class AddAddressResponse {
    private boolean successfullyAddAddress;

    public boolean isSuccessfullyAddAddress() {
        return successfullyAddAddress;
    }

    public void setSuccessfullyAddAddress(boolean successfullyAddAddress) {
        this.successfullyAddAddress = successfullyAddAddress;
    }
}
