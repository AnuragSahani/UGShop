package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.network.ErrorResponse;

import java.util.List;

public class FetchProductListResponse extends ResponseEntity {
    private List<ProductModel> fetchingProductList;
    private ErrorResponse errorResponse ;

    public List<ProductModel> getFetchingProductList() {
        return fetchingProductList;
    }
    public void setFetchingProductList(List<ProductModel> fetchingProductList) {
        this.fetchingProductList = fetchingProductList;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
