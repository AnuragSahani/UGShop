package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class FetchCategoryResponse extends ResponseEntity {
    List<CategoryModel> listCat = new ArrayList<CategoryModel>();

    public List<CategoryModel> getListCat() {
        return listCat;
    }

    public void setListCat(List<CategoryModel> listCat) {
        this.listCat = listCat;
    }
}
