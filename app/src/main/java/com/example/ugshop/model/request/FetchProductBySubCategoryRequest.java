package com.example.ugshop.model.request;

public class FetchProductBySubCategoryRequest {
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
