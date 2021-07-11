package com.example.ugshop.model.response;

import com.example.ugshop.model.ResponseEntity;
import com.example.ugshop.model.common.AddressModel;
import com.example.ugshop.network.ErrorResponse;

import java.util.ArrayList;
import java.util.List;

public class FetchAddressResponse extends ResponseEntity {
    private ErrorResponse error;
    private List<AddressModel> addressList = new ArrayList<AddressModel>();

    @Override
    public String toString() {
        return "FetchAddressResponse{" +
                "error=" + error +
                ", addressList=" + addressList +
                '}';
    }

    public List<AddressModel> getFetchResList() {
        return addressList;
    }

    public void setFetchResList(List<AddressModel> fetchResList) {
        this.addressList = fetchResList;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
