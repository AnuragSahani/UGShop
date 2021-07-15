package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.request.SignupRequest;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

public class SignupViewModel extends ViewModel {

    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<SignupResponse>> signup(String email, String password, String username, String mobilenumber) {
        //TODO: validate() : emailText not empty && it should be a proper email value
        // TODO: password not empty
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail(email);
        signupRequest.setPassword(password);
        signupRequest.setUsername(username);
        signupRequest.setMobilenumber(mobilenumber);
        return repository.signup(signupRequest);
    }
}
