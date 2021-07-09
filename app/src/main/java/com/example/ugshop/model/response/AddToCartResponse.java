package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;

public class AddToCartResponse extends ResponseEntity {

    private boolean successAddToCart;

    public boolean isSuccessAddToCart() {
        return successAddToCart;
    }

    public void setSuccessAddToCart(boolean successAddToCart) {
        this.successAddToCart = successAddToCart;
    }
}
