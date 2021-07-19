package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.CartModel;

public class RemoveFromCartRequest extends RequestEntity {
    private String user;
    private CartModel cartModel;
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }
}
