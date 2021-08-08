package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.request.PlaceOrderRequest;
import com.example.ugshop.model.response.FetchOrderResponse;
import com.example.ugshop.model.response.PlaceOrderResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

public class OrderViewModel extends ViewModel {
    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<PlaceOrderResponse>> placeOrder(PlaceOrderRequest request){
        return  repository.placeOrder(request);
    }

    public  LiveData<ApiResource<FetchOrderResponse>> fetchOrderList(String email){
        return repository.fetchOrderList(email);
    }
}
