package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.FetchProductBySubCategoryresponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

import java.util.List;

public class ProductListViewModel extends ViewModel {
    private UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<FetchProductListResponse>> fetchProductList(){
        return repository.fetchProductList();
    }

    public LiveData<ApiResource<AddToCartResponse>> addToCart(AddToCartRequest request){
        return repository.addToCart(request);
    }

    public LiveData<ApiResource<FetchProductBySubCategoryresponse>> fetchProductBySubCategory (int catId, int subCatId){
        return  repository.fetchProductBySubCategory ( catId,subCatId);
    }
}
