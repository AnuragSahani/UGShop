package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.network.ErrorResponse;

import java.util.List;

public class ViewCartResponse extends ResponseEntity {
        private ErrorResponse errorResponse;
        private List<CartModel> listCart;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public List<CartModel> getListCart() {
        return listCart;
    }

    public void setListCart(List<CartModel> listCart) {
        this.listCart = listCart;
    }
}
