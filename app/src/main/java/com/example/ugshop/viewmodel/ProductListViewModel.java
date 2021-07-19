package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

import java.util.List;

public class ProductListViewModel extends ViewModel {
    private UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<FetchProductListResponse>> fetchProductList(){
        return repository.fetchProductList();
    }
}
