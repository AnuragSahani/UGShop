package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class FetchCategoryResponse extends ResponseEntity {
    List<CategoryModel> listCategories = new ArrayList<CategoryModel>();

    public List<CategoryModel> getListCat() {
        return listCategories;
    }

    public void setListCat(List<CategoryModel> listCat) {
        this.listCategories = listCat;
    }
}
