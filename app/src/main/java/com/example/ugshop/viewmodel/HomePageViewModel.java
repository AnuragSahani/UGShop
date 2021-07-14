package com.example.ugshop.viewmodel;

import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class HomePageViewModel extends ViewModel {
    UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<FetchCategoryResponse>> fetchCategoryList() {
        return repository.fetchCategories();
    }
}
