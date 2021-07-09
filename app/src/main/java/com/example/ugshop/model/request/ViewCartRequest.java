package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class ViewCartRequest extends RequestEntity {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
