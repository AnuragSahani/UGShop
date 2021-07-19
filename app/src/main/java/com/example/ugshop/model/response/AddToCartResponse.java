package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.network.ErrorResponse;

public class AddToCartResponse extends ResponseEntity {

    private boolean successAddToCart;
    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public boolean isSuccessAddToCart() {
        return successAddToCart;
    }

    public void setSuccessAddToCart(boolean successAddToCart) {
        this.successAddToCart = successAddToCart;
    }
}
