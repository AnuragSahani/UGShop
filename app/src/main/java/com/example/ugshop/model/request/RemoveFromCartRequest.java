package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.ProductTypeModel;

public class RemoveFromCartRequest extends RequestEntity {
    private String user;
    private ProductTypeModel product;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ProductTypeModel getProduct() {
        return product;
    }

    public void setProduct(ProductTypeModel product) {
        this.product = product;
    }
}
