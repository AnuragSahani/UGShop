package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.AddressModel;

public class AddAddressRequest extends RequestEntity {
    private AddressModel addressModel;

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }
}