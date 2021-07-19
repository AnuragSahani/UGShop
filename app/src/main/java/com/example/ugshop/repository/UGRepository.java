package com.example.ugshop.repository;

import androidx.lifecycle.LiveData;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.AddAddressRequest;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.request.SignupRequest;
import com.example.ugshop.model.request.ViewCartRequest;
import com.example.ugshop.model.response.AddAddressResponse;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.ChangePasswordResponse;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.model.response.ViewCartResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.network.RetrofitLiveData;
import com.example.ugshop.network.UGRetrofitApis;
import com.example.ugshop.network.UGRetrofitBuilder;

import java.util.List;

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

    public LiveData<ApiResource<SignupResponse>> signup(SignupRequest signupRequest) {
        return new RetrofitLiveData<>(sNetworkApi.signup(signupRequest));
    }

    public LiveData<ApiResource<FetchCategoryResponse>> fetchCategories() {
        return new RetrofitLiveData<>(sNetworkApi.fetchCategoryList());
    }

    public LiveData<ApiResource<FetchProductListResponse>> fetchProductList() {
        return new RetrofitLiveData<>(sNetworkApi.fetchProductList());
    }

    public LiveData<ApiResource<FetchAddressResponse>> fetchAddress(FetchAddressRequest request) {
        return new RetrofitLiveData<>(sNetworkApi.fetchAddress(request));
    }
    public  LiveData<ApiResource<AddAddressResponse>> addAddress(AddAddressRequest request){
        return  new RetrofitLiveData<>(sNetworkApi.addAddress(request));
    }

    public  LiveData<ApiResource<AddToCartResponse>> addToCart(AddToCartRequest addToCartRequest){
        return new RetrofitLiveData<>(sNetworkApi.addToCart(addToCartRequest));
    }
    public LiveData<ApiResource<ChangePasswordResponse>> changePassword(LoginRequest loginRequest) {
        return new RetrofitLiveData<>(sNetworkApi.changePassword(loginRequest));
    }
    public LiveData<ApiResource<ViewCartResponse>> viewCart(ViewCartRequest viewCartRequest) {
        return  new RetrofitLiveData<>(sNetworkApi.viewCart(viewCartRequest));
    }
    public RetrofitLiveData<CatsResponse> getCatsApi() {
        return new RetrofitLiveData<>(sNetworkApi.getCatsApi());
    }
}
