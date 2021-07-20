package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.network.ErrorResponse;

public class AddToCartResponse extends ResponseEntity {

    private boolean added;
    private ErrorResponse error;

    @Override
    public String toString() {
        return "AddToCartResponse{" +
                "added=" + added +
                ", error=" + error +
                '}';
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
