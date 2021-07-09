package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class FetchProductBySubCategoryRequest extends RequestEntity {
    private int catId;
    private int subCatId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }
}
