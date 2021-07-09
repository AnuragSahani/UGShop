package com.example.ugshop.model.request;

import com.example.ugshop.model.common.AddressModel;

public class AddAddressRequest {
    private AddressModel address;
    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
