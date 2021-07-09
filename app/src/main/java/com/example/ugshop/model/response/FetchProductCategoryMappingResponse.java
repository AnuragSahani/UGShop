package com.example.ugshop.model.response;

import com.example.ugshop.model.common.ProductCategoryMappingModel;

import java.util.ArrayList;
import java.util.List;

public class FetchProductCategoryMappingResponse {
    List<ProductCategoryMappingModel> listProCat = new ArrayList<ProductCategoryMappingModel>();

    public List<ProductCategoryMappingModel> getListProCat() {
        return listProCat;
    }

    public void setListProCat(List<ProductCategoryMappingModel> listProCat) {
        this.listProCat = listProCat;
    }
}
