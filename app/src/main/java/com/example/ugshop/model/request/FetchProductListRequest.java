package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;
import com.example.ugshop.model.common.ProductModel;

import java.util.List;

public class FetchProductListRequest extends RequestEntity {
    //TODO::
    private List<ProductModel> listProduct;

    public List<ProductModel> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductModel> listProduct) {
        this.listProduct = listProduct;
    }
}
