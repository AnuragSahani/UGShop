package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.request.GenerateOtpRequest;
import com.example.ugshop.model.request.SignupRequest;
import com.example.ugshop.model.response.GenerateOtpResponse;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

public class GenerateOtpViewModel extends ViewModel {
    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<GenerateOtpResponse>> generateOtp (String email) {

        /*GenerateOtpRequest generateOtpRequest = new GenerateOtpRequest();
        generateOtpRequest.setEmail(email);*/

        return repository.generateOtp(email);
    }


}
