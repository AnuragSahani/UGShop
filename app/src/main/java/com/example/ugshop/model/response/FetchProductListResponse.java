package com.example.ugshop.model.response;

import com.example.ugshop.model.common.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class FetchProductListResponse {
    List<ProductModel> fetchingSuccessProductList = new ArrayList<ProductModel>();

    public List<ProductModel> getFetchingSuccessProductList() {
        return fetchingSuccessProductList;
    }

    public void setFetchingSuccessProductList(List<ProductModel> fetchingSuccessProductList) {
        this.fetchingSuccessProductList = fetchingSuccessProductList;
    }
}
