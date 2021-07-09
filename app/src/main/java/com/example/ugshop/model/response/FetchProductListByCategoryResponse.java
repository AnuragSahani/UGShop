package com.example.ugshop.model.response;

import com.example.ugshop.model.common.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class FetchProductListByCategoryResponse {
    List<ProductModel> proModel = new ArrayList<ProductModel>();

    public List<ProductModel> getProModel() {
        return proModel;
    }

    public void setProModel(List<ProductModel> proModel) {
        this.proModel = proModel;
    }
}
