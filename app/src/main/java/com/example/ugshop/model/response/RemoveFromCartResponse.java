package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;

public class RemoveFromCartResponse extends ResponseEntity {
    private boolean successRemoveFromCart;

    public boolean isSuccessRemoveFromCart() {
        return successRemoveFromCart;
    }

    public void setSuccessRemoveFromCart(boolean successRemoveFromCart) {
        this.successRemoveFromCart = successRemoveFromCart;
    }
}
