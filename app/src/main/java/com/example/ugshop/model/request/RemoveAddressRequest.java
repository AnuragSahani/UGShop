package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class RemoveAddressRequest extends RequestEntity {
    private String email;
    private int addressId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
