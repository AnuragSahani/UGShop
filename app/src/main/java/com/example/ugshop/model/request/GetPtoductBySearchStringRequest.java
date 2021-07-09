package com.example.ugshop.model.request;

import com.example.ugshop.model.RequestEntity;

public class GetPtoductBySearchStringRequest extends RequestEntity {
    private String inputSearch;

    public String getInputSearch() {
        return inputSearch;
    }

    public void setInputSearch(String inputSearch) {
        this.inputSearch = inputSearch;
    }
}
