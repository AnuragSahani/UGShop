package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.response.GenerateOtpResponse;
import com.example.ugshop.model.response.VerifyOtpResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

public class VerifyOtpViewModel extends ViewModel {
    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<VerifyOtpResponse>> verifyOtp (int otp, String email) {

        /*GenerateOtpRequest generateOtpRequest = new GenerateOtpRequest();
        generateOtpRequest.setEmail(email);*/

        return repository.verifyOtp(otp,email);
    }

}
