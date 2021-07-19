package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.CartModel;

public class AddToCartRequest extends RequestEntity {
    private String userEmail;
    private CartModel cartModel;
    public CartModel getCartModel() {
        return cartModel;
    }
    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


}
