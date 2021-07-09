package com.example.ugshop.model.response;
import com.example.ugshop.model.common.CategoryModel;
import java.util.List;
import java.util.ArrayList;

public class FetchCategoryResponse {
    List<CategoryModel> listCat = new ArrayList<CategoryModel>();

    public List<CategoryModel> getListCat() {
        return listCat;
    }

    public void setListCat(List<CategoryModel> listCat) {
        this.listCat = listCat;
    }
}
