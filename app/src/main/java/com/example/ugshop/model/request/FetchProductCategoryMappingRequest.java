package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class FetchProductCategoryMappingRequest extends RequestEntity {
    private int catId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
