package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.request.AddAddressRequest;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.response.AddAddressResponse;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

public class AddressPageViewModel extends ViewModel {
    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<FetchAddressResponse>> fetchAddresses(FetchAddressRequest request) {
        return repository.fetchAddress(request);
    }

    public LiveData<ApiResource<AddAddressResponse>> addAddress(AddAddressRequest request) {
        return repository.addAddress(request);
    }
}
