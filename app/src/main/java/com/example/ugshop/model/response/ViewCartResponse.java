package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.network.ErrorResponse;

import java.util.List;

public class ViewCartResponse extends ResponseEntity {
    private ErrorResponse error;
    private List<ProductModel> map;

    @Override
    public String toString() {
        return "ViewCartResponse{" +
                "error=" + error +
                ", productList=" + map +
                '}';
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    public List<ProductModel> getProductList() {
        return map;
    }

    public void setProductList(List<ProductModel> productList) {
        this.map = productList;
    }
}
