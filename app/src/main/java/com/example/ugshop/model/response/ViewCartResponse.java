package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.network.ErrorResponse;

import java.util.List;

public class ViewCartResponse extends ResponseEntity {
        private ErrorResponse error;
    private List<ProductModel> productList;

    @Override
    public String toString() {
        return "ViewCartResponse{" +
                "error=" + error +
                ", productList=" + productList +
                '}';
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductModel> productList) {
        this.productList = productList;
    }
}
