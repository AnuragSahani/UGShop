package com.example.ugshop.model.response;

import com.example.ugshop.model.common.AddressModel;

import java.util.ArrayList;
import java.util.List;

public class FetchAddressResponse {
    private List <AddressModel> fetchResList = new ArrayList<AddressModel>();

    public List<AddressModel> getFetchResList() {
        return fetchResList;
    }

    public void setFetchResList(List<AddressModel> fetchResList) {
        this.fetchResList = fetchResList;
    }
}
