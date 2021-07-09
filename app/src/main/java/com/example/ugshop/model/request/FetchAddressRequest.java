package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class FetchAddressRequest extends RequestEntity {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
