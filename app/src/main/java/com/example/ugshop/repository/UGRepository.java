package com.example.ugshop.repository;

import androidx.lifecycle.LiveData;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.AddAddressRequest;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.request.RemoveFromCartRequest;
import com.example.ugshop.model.request.SignupRequest;
import com.example.ugshop.model.response.AddAddressResponse;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.ChangePasswordResponse;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.model.response.GenerateOtpResponse;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.model.response.RemoveFromCartResponse;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.model.response.VerifyOtpResponse;
import com.example.ugshop.model.response.ViewCartResponse;
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

    public LiveData<ApiResource<SignupResponse>> signup(SignupRequest signupRequest) {
        return new RetrofitLiveData<>(sNetworkApi.signup(signupRequest));
    }

    public LiveData<ApiResource<FetchCategoryResponse>> fetchCategories() {
        return new RetrofitLiveData<>(sNetworkApi.fetchCategoryList());
    }

    public LiveData<ApiResource<FetchProductListResponse>> fetchProductList() {
        return new RetrofitLiveData<>(sNetworkApi.fetchProductList());
    }

    public LiveData<ApiResource<FetchAddressResponse>> fetchAddress(String email) {
        return new RetrofitLiveData<>(sNetworkApi.fetchAddress(email));
    }

    public LiveData<ApiResource<AddAddressResponse>> addAddress(AddAddressRequest request) {
        return new RetrofitLiveData<>(sNetworkApi.addAddress(request));
    }

    public LiveData<ApiResource<AddToCartResponse>> addToCart(AddToCartRequest addToCartRequest) {
        return new RetrofitLiveData<>(sNetworkApi.addToCart(addToCartRequest));
    }

    public LiveData<ApiResource<ChangePasswordResponse>> changePassword(LoginRequest loginRequest) {
        return new RetrofitLiveData<>(sNetworkApi.changePassword(loginRequest));
    }

    public LiveData<ApiResource<ViewCartResponse>> viewCart(String email) {
        return new RetrofitLiveData<>(sNetworkApi.viewCart(email));
    }

    public RetrofitLiveData<CatsResponse> getCatsApi() {
        return new RetrofitLiveData<>(sNetworkApi.getCatsApi());
    }

    public LiveData<ApiResource<RemoveFromCartResponse>> removeFromCart(RemoveFromCartRequest removeFromCartRequest) {
        return new RetrofitLiveData<>(sNetworkApi.removeFromCart(removeFromCartRequest));
    }

    public LiveData<ApiResource<GenerateOtpResponse>> generateOtp(String email) {
        return new RetrofitLiveData<>(sNetworkApi.generateOtp(email));
    }

    public LiveData<ApiResource<VerifyOtpResponse>> verifyOtp(int otp, String email) {
        return new RetrofitLiveData<>(sNetworkApi.verifyOtp(otp, email));
    }

    public LiveData<ApiResource<FetchProductListResponse>> fetchProductBySubCategory(int catId, int subCatId) {
        return new RetrofitLiveData<>(sNetworkApi.fetchProductBySubCategory(catId, subCatId));
    }
}
