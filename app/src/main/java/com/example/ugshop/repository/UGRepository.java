package com.example.ugshop.repository;

import androidx.lifecycle.LiveData;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.network.RetrofitLiveData;
import com.example.ugshop.network.UGRetrofitApis;
import com.example.ugshop.network.UGRetrofitBuilder;

public class UGRepository {

    private static UGRepository sInstance;
    private static UGRetrofitApis sNetworkApi;

    public static UGRepository getInstance() {
        if (sInstance == null) {
            sInstance = new UGRepository();
            sNetworkApi = UGRetrofitBuilder.getNetworkApi();
        }
        return sInstance;
    }

    public LiveData<ApiResource<LoginResponse>> login(LoginRequest loginRequest) {
        return new RetrofitLiveData<>(sNetworkApi.fetchLogIn(loginRequest));
    }

    public LiveData<ApiResource<FetchCategoryResponse>> fetchCategories() {
        return new RetrofitLiveData<>(sNetworkApi.fetchCategoryList());
    }

    public LiveData<ApiResource<FetchAddressResponse>> fetchAddress(FetchAddressRequest request) {
        return new RetrofitLiveData<>(sNetworkApi.fetchAddress(request));
    }

    public RetrofitLiveData<CatsResponse> getCatsApi() {
        return new RetrofitLiveData<>(sNetworkApi.getCatsApi());
    }
}
