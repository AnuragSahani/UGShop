package com.example.ugshop.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.request.ViewCartRequest;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.ViewCartResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.repository.UGRepository;

public class CartViewModel extends ViewModel {
    private final UGRepository repository = UGRepository.getInstance();

    public LiveData<ApiResource<ViewCartResponse>> viewCart(String email){
        ViewCartRequest viewCartRequest = new ViewCartRequest();
        viewCartRequest.setUser(email);
        return  repository.viewCart(viewCartRequest);
    }


    public LiveData<ApiResource<AddToCartResponse>> addToCart(String email, CartModel cartModel){
        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setCartModel(cartModel);
        addToCartRequest.setUserEmail(email);
        return  repository.addToCart(addToCartRequest);
    }
}
