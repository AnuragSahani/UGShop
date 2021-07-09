package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.ProductTypeModel;

public class AddToCartRequest extends RequestEntity {
    private String userEmail;
    private ProductTypeModel product;
    private int quantity;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ProductTypeModel getProduct() {
        return product;
    }

    public void setProduct(ProductTypeModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
