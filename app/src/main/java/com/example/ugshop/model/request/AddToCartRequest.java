package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.CartModel;

public class AddToCartRequest extends RequestEntity {
    private String email;
    private CartModel cartModel;

    public CartModel getCartModel() {
        return cartModel;
    }

    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
