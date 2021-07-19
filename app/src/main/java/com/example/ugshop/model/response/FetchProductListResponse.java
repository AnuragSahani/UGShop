package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.network.ErrorResponse;

import java.util.List;

public class FetchProductListResponse extends ResponseEntity {
    private List<ProductModel> productList;
    private ErrorResponse error ;

    public List<ProductModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductModel> productList) {
        this.productList = productList;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
