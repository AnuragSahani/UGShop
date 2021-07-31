package com.example.ugshop.viewmodel;

import android.os.Build;

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

import java.util.Base64;

public class LoginPageViewModel extends ViewModel {//Model -> data -> view

    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<LoginResponse>> login(String emailText, String password) {
        //TODO: validate() : emailText not empty && it should be a proper email value
        // TODO: password not empty
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(emailText);
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            loginRequest.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
        } else */{
            loginRequest.setPassword(password);
        }
        return repository.login(loginRequest);
    }

    public LiveData<ApiResource<FetchAddressResponse>> fetchAddresses(String email) {
        return repository.fetchAddress(email);
    }

    public RetrofitLiveData<CatsResponse> getCats() {
        return repository.getCatsApi();
    }
}
