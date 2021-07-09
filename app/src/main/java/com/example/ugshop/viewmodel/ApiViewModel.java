package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.network.RetrofitLiveData;
import com.example.ugshop.repository.UGRepository;

public class ApiViewModel extends ViewModel {

    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<LoginResponse>> login(LoginRequest loginRequest) {
        return repository.login(loginRequest);
    }

    public LiveData<ApiResource<FetchAddressResponse>> fetchAddresses(FetchAddressRequest request) {
        return repository.fetchAddress(request);
    }

    public RetrofitLiveData<CatsResponse> getCats() {
        return repository.getCatsApi();
    }
}
