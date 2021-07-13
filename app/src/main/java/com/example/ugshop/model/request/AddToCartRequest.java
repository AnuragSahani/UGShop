package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class AddToCartRequest extends RequestEntity {
    private String userEmail;
    private int quantity;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
